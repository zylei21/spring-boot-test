package com.cibei.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootFristApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFristApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.err.println("查看自动注入的bean");
            String[]beanNames=ctx.getBeanDefinitionNames();
            for (String bean:beanNames){
                System.err.println(bean);
            }
        };
    }

}
