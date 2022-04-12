package com.github.sparkzxl.oauth.infrastructure.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description: security 自动装配属性配置
 *
 * @author charles.zhou
 * @date 2020-07-14 16:24:55
 */
@Data
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private List<String> ignorePatterns;

    private List<String> ignoreStaticPatterns;

    private boolean csrf = true;
}
