package com.github.sparkzxl.oauth.infrastructure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * description: security 自动装配属性配置
 *
 * @author charles.zhou
 * @date 2020-07-14 16:24:55
 */
@Component
@Data
@ConfigurationProperties(prefix = "system")
public class SystemProperties {
    private String name;
}
