package com.github.sparkzxl.auth.infrastructure.config;

import cn.hutool.core.util.ArrayUtil;
import com.github.sparkzxl.auth.domain.service.UserDetailsServiceImpl;
import com.github.sparkzxl.auth.infrastructure.constant.SecurityConstants;
import com.github.sparkzxl.auth.infrastructure.security.filter.TenantLoginPreFilter;
import com.github.sparkzxl.auth.infrastructure.security.RestfulAccessDeniedHandler;
import com.github.sparkzxl.auth.infrastructure.security.SecurityProperties;
import com.github.sparkzxl.auth.infrastructure.security.filter.PermitAuthenticationFilter;
import com.github.sparkzxl.auth.infrastructure.security.filter.mobile.SmsCodeAuthenticationSecurityConfig;
import com.github.sparkzxl.auth.infrastructure.security.logout.CustomizeLogoutSuccessHandler;
import com.github.sparkzxl.core.resource.SwaggerStaticResource;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * description: 安全认证
 *
 * @author charles.zhou
 * @date 2021-02-23 14:19:05
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private SecurityProperties securityProperties;
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Autowired
	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	@Autowired
	public void setSmsCodeAuthenticationSecurityConfig(SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig) {
		this.smsCodeAuthenticationSecurityConfig = smsCodeAuthenticationSecurityConfig;
	}
	
	@Override
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public TenantLoginPreFilter tenantLoginPreFilter() {
		return new TenantLoginPreFilter();
	}
	
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomizeLogoutSuccessHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PermitAuthenticationFilter permitAuthenticationFilter() {
		return new PermitAuthenticationFilter();
	}
	
	@Bean
	public PermitAllSecurityConfig permitAllSecurityConfig() {
		PermitAllSecurityConfig permitAllSecurityConfig = new PermitAllSecurityConfig();
		permitAllSecurityConfig.setPermitAuthenticationFilter(permitAuthenticationFilter());
		return permitAllSecurityConfig;
		
	}
	
	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		RestfulAccessDeniedHandler restfulAccessDeniedHandler = new RestfulAccessDeniedHandler();
		List<String> ignorePatternList = Lists.newArrayList(
				SecurityConstants.DEFAULT_LOGIN_URL,
				SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM,
				SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
				SecurityConstants.DEFAULT_SIGN_IN_URL_MOBILE_PAGE,
				SecurityConstants.DEFAULT_REGISTER_URL,
				SecurityConstants.DEFAULT_SIGN_IN_TOKEN_REQUEST, SecurityConstants.MOCK_REQUEST);
		ignorePatternList.addAll(securityProperties.getIgnorePatterns());
		if (CollectionUtils.isNotEmpty(ignorePatternList)) {
			http.authorizeRequests()
					.antMatchers(ArrayUtil.toArray(ignorePatternList, String.class)).permitAll();
		}
		http.authorizeRequests()
				.requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll();
		if (!securityProperties.isCsrf()) {
			http.csrf().disable();
		}
		http.apply(smsCodeAuthenticationSecurityConfig)
				.and()
				.logout().logoutUrl("/logout")
				.logoutSuccessHandler(logoutSuccessHandler())
				.deleteCookies("JSESSIONID")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.permitAll()
				.and().authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage(SecurityConstants.DEFAULT_LOGIN_URL)
				.loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
				.permitAll()
				.and()
				.httpBasic()
				.and()
				.exceptionHandling()
				.accessDeniedHandler(restfulAccessDeniedHandler)
				.and()
				.addFilterBefore(tenantLoginPreFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Override
	public void configure(WebSecurity web) {
		List<String> ignoreStaticPatterns = Lists.newArrayList();
		ignoreStaticPatterns.addAll(SwaggerStaticResource.EXCLUDE_STATIC_PATTERNS);
		List<String> staticPatterns = securityProperties.getIgnoreStaticPatterns();
		if (CollectionUtils.isNotEmpty(staticPatterns)) {
			ignoreStaticPatterns.addAll(staticPatterns);
		}
		web.ignoring().antMatchers(ArrayUtil.toArray(ignoreStaticPatterns, String.class));
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		web.httpFirewall(firewall);
	}
	
}
