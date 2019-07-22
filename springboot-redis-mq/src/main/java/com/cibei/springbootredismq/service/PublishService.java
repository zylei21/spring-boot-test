package com.cibei.springbootredismq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 9:40
 */
@Service
public class PublishService {

    @Autowired
    StringRedisTemplate template;

    public String sendMessage(String name,String message){
        try {
            template.convertAndSend("chat",name+":"+message);
            return "发送成功";
        }catch (Exception e){
            e.printStackTrace();
            return "发送失败";
        }
    }
}