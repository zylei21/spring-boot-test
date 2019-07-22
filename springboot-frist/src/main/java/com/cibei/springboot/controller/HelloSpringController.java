package com.cibei.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/28 11:28
 */
@RestController
public class HelloSpringController {
    @RequestMapping("/")
    public String index(){
        return "helloSpring!";
    }
}
