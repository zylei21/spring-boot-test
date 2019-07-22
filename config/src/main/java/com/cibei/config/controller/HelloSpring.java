package com.cibei.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/16 11:00
 */
@RestController
public class HelloSpring {
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private String age;

    @RequestMapping("/hello")
    public String hi(){
        return name +" :"+age;
    }
}
