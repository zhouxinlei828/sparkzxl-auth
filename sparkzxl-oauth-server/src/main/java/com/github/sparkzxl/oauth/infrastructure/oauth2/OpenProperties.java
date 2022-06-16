package com.github.sparkzxl.oauth.infrastructure.oauth2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description: open 自动装配属性配置
 *
 * @author charles.zhou
 * @since 2020-07-14 16:24:55
 */
@Data
@ConfigurationProperties(prefix = "open")
public class OpenProperties {

    private String appId;

    private String ssoServerUri;

    private String logout;

}
