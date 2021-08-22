package com.github.sparkzxl.ids.application.service;

import com.fujieid.jap.ids.config.JwtConfig;
import com.fujieid.jap.ids.service.IdsIdentityService;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author zhoux
 * @date 2021-08-22 19:20:33
 */
@Service
public class IdsIdentityServiceImpl implements IdsIdentityService {
    /**
     * Get the jwt token encryption key string
     *
     * @param identity User/organization/enterprise identification
     * @return Encryption key string in json format
     */
    @Override
    public String getJwksJson(String identity) {
        return IdsIdentityService.super.getJwksJson(identity);
    }

    /**
     * Get the configuration of jwt token encryption
     *
     * @param identity User/organization/enterprise identification
     * @return Encryption key string in json format
     */
    @Override
    public JwtConfig getJwtConfig(String identity) {
        return IdsIdentityService.super.getJwtConfig(identity);
    }
}
