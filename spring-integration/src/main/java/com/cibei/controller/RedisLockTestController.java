package com.cibei.controller;

import ch.qos.logback.core.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/22 15:04
 */
@RestController
@RequestMapping("/redis")
public class RedisLockTestController {
    private static final Logger LOGGER= LoggerFactory.getLogger(RedisLockTestController.class);

    @Autowired
    RedisLockRegistry redisLockRegistry;
    @GetMapping("/test")
    public void test() throws InterruptedException{
        Lock lock=redisLockRegistry.obtain("lock");
        boolean isLock=lock.tryLock(3, TimeUnit.SECONDS);
        LOGGER.info("isLock : {}" ,isLock);
        TimeUnit.SECONDS.sleep(5);
        boolean isLock2=lock.tryLock(3, TimeUnit.SECONDS);
        LOGGER.info("isLock : {}" ,isLock2);

        lock.unlock();
        lock.unlock();
    }
}
