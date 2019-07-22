package com.cibei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/22 14:34
 */
@RestController
@RequestMapping("/logger")
public class LoggerTestController {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggerTestController.class);

    @GetMapping("/test")
    public String simple(){
        LOGGER.debug("这是一个debug日志....");
        return "test";
    }
}
