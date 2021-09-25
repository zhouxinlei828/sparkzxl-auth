package com.github.sparkzxl.oauth.interfaces.controller;

import com.github.sparkzxl.jwt.service.JwtTokenService;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.nimbusds.jose.jwk.JWKSet;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * description：密钥管理
 *
 * @author charles.zhou
 * @date 2020/6/6 9:08 上午
 */
@RestController
@HttpRequestLog
@Api(tags = "密钥管理")
@Slf4j
public class JwtValidationController {

    private JwtTokenService jwtTokenService;

    @Autowired
    public void setJwtTokenService(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @GetMapping("/rsa/publicKey")
    public Map<String, Object> publicKey() {
        log.info("获取公钥====");
        return new JWKSet(jwtTokenService.getRsaPublicKey()).toJSONObject();
    }

}
