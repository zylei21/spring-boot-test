package com.cibei.springbootconfig.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/06/28 14:14
 *
 * 读取properties中的属性值并将期赋值到javabean上面
 * 1@Configuration
 * 2@PropertySource(value = "classpath:test.properties")
 * 3@ConfigurationProperties(prefix = "com.forezp")
 * 4@Component
 */

@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "my")
@Component
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
