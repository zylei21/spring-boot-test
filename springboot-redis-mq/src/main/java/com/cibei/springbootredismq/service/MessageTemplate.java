package com.cibei.springbootredismq.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 9:09
 * 注册一个stringRedisTemplate
 */
@Configuration
public class MessageTemplate {
    public StringRedisTemplate getTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }
}
