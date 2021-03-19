package com.github.sparkzxl.gateway.infrastructure.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * description: Redis配置
 *
 * @author charles.zhou
 * @date   2020-08-02 22:38:50
 */
@Configuration
@EnableRedisRepositories
public class RedisRepositoryConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        RedisSerializer<Object> fastJsonSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(fastJsonSerializer);
        redisTemplate.setValueSerializer(fastJsonSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
