package com.github.sparkzxl.oauth.infrastructure.config;

import com.github.sparkzxl.jwt.properties.JwtProperties;
import com.github.sparkzxl.jwt.properties.KeyStoreProperties;
import com.github.sparkzxl.oauth.domain.service.ClientDetailsServiceImpl;
import com.github.sparkzxl.oauth.infrastructure.oauth2.Oauth2ExceptionHandler;
import com.github.sparkzxl.oauth.infrastructure.oauth2.OpenProperties;
import com.github.sparkzxl.oauth.infrastructure.oauth2.enhancer.JwtTokenEnhancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.endpoint.CustomTokenGrantService;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * description: 授权服务器配置
 *
 * @author charles.zhou
 * @date 2021-02-23 14:13:03
 */
@Configuration
@EnableAuthorizationServer
@EnableConfigurationProperties(OpenProperties.class)
@Import(Oauth2ExceptionHandler.class)
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;

    private JwtProperties jwtProperties;

    private UserDetailsService userDetailsService;

    private RedisConnectionFactory connectionFactory;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(connectionFactory);
        redisTokenStore.setPrefix("oauth_token:");
        return redisTokenStore;
    }

    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }

    @Bean
    public CustomTokenGrantService customTokenGrantService(TokenEndpoint tokenEndpoint) {
        return new CustomTokenGrantService(tokenEndpoint);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("SparkAuth");
        KeyStoreProperties keyStore = jwtProperties.getKeyStore();
        if (keyStore.isEnable()) {
            KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(keyStore.getPath()),
                    keyStore.getPassword().toCharArray());
            KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", keyStore.getPassword().toCharArray());
            Optional.ofNullable(keyPair).ifPresent(jwtAccessTokenConverter::setKeyPair);
        }
        return jwtAccessTokenConverter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore());
        JwtAccessTokenConverter jwtAccessTokenConverter = accessTokenConverter();
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer());
        delegates.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates);
        endpoints.accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(enhancerChain);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) {
        securityConfigurer.allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new ClientDetailsServiceImpl();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

}
