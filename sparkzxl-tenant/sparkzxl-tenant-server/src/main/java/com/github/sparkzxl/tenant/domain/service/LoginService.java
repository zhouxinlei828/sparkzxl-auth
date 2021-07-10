package com.github.sparkzxl.tenant.domain.service;

import com.github.sparkzxl.constant.BaseContextConstants;
import com.github.sparkzxl.core.utils.BuildKeyUtils;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.entity.security.AuthRequest;
import com.github.sparkzxl.entity.security.AuthToken;
import com.github.sparkzxl.entity.security.SecurityUserDetail;
import com.github.sparkzxl.jwt.properties.JwtProperties;
import com.github.sparkzxl.jwt.service.JwtTokenService;
import com.github.sparkzxl.security.service.AbstractSecurityLoginService;
import com.github.sparkzxl.tenant.domain.repository.ITenantManagerRepository;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/***
 * description: 登录service
 *
 * @author zhouxinlei
 * @date 2021-07-03 13:10:43
 */
@Service
public class LoginService extends AbstractSecurityLoginService<Long> {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ITenantManagerRepository tenantManagerRepository;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void checkPasswordError(AuthRequest authRequest, SecurityUserDetail<Long> authUserDetail) throws PasswordException {
        String password = authRequest.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        if (passwordEncoder.matches(encodePassword, authUserDetail.getPassword())) {
            throw new PasswordException("密码错误");
        }
    }

    @Override
    public AuthUserInfo getAuthUserInfo(String username) {
        return tenantManagerRepository.getAuthUserInfo(username);
    }

    @Override
    public void accessToken(AuthToken authToken, AuthUserInfo authUserInfo) {
        String authUserInfoKey = BuildKeyUtils.generateKey(BaseContextConstants.AUTH_USER_TOKEN, authUserInfo.getId());
        redisTemplate.opsForHash().put(authUserInfoKey, authToken.getAccessToken(), authUserInfo);
        redisTemplate.expire(authUserInfoKey, authToken.getExpiration(), TimeUnit.SECONDS);
    }

    @Override
    public JwtProperties getJwtProperties() {
        return jwtProperties;
    }

    @Override
    public JwtTokenService<Long> getJwtTokenService() {
        return jwtTokenService;
    }

    @Override
    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
}
