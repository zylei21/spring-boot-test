package com.cibei.springbootredismq.controller;

import com.cibei.springbootredismq.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 9:45
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    PublishService publishService;

    @PostMapping
    public String sendMessage(@RequestParam("name")String name,@RequestParam("message")String message){
        return publishService.sendMessage(name,message);
    }
}
