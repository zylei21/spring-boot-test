package com.cibei.springbootredismq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootRedisMqApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx =  SpringApplication.run(SpringbootRedisMqApplication.class, args);
    }
}
