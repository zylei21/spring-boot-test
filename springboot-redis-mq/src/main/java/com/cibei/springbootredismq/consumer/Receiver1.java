package com.cibei.springbootredismq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 9:56
 * 不继承
 */
@Component
public class Receiver1 {
    private static final Logger LOGGER= LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message){
        LOGGER.info(message);
    }
}
