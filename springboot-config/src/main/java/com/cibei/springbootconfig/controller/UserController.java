package com.cibei.springbootconfig.controller;

import com.cibei.springbootconfig.bean.Person;
import com.cibei.springbootconfig.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/28 14:18
 */
@RestController
//@EnableConfigurationProperties({User.class})
public class UserController {
    @Autowired
    User user;

    @RequestMapping("/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}
