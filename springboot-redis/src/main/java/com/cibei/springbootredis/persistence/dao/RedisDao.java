package com.cibei.springbootredis.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 10:45
 */

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public void setValue(String key, String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, 2, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

}
