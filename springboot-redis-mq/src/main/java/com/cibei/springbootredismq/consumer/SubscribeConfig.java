package com.cibei.springbootredismq.consumer;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 9:59
 */
@Configuration
@AutoConfigureAfter({Receiver.class})
public class SubscribeConfig {
    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(Receiver receiver ){
        //继承的不需要写方法名
        return new MessageListenerAdapter(receiver);
    }

    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer redisMessageListenerContainer=new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);

        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,new PatternTopic("chat"));

        return redisMessageListenerContainer;
    }
}
