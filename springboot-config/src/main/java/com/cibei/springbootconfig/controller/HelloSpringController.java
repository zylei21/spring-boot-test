package com.cibei.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/28 13:22
 *
 * 通过注解@value可以将application.yml中自定义的属性值取出来
 */
@RestController
public class HelloSpringController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;
    @RequestMapping("/my")
    public String helloSpring(){
        return name+age;
    }
}
