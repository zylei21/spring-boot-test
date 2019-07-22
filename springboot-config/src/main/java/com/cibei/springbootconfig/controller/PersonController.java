package com.cibei.springbootconfig.controller;

import com.cibei.springbootconfig.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/28 14:06
 */
@RestController
@EnableConfigurationProperties({Person.class})
public class PersonController {

    @Autowired
    Person person;
    @RequestMapping("/person")
    public String sayhi(){
        return person.getSayhi()+">>>>"+person.getName()+person.getUuid()+person.getAge()+person.getNum()+person.getMax()+person.getValue()+"<<<<";
    }
}
