package com.cibei.springbootconfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootConfigApplicationTests {

    @Autowired
    TestRestTemplate template;

    @LocalServerPort
    private int port;
    URL base;

    @Before
    public void setup()throws Exception{
        base=new URL("http://localhost:"+port+"/user");
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> response=template.getForEntity(this.base.toString(),String.class);
        System.err.println(response.getBody());
    }

}
