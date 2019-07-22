package com.cibei.springbootredismq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 9:49
 * 继承的写法
 */
@Component
public class Receiver implements MessageListener {
    private static final Logger LOGGER= LoggerFactory.getLogger(Receiver.class);

    @Autowired
    StringRedisTemplate template;
    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> serializer= template.getStringSerializer();
        String strMsg=serializer.deserialize(message.getBody());
        LOGGER.info("收到的消息:"+strMsg);
    }
}
