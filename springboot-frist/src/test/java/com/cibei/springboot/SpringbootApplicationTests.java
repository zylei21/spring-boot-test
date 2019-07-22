package com.cibei.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootApplicationTests {

    @LocalServerPort
    private int port;
    private URL url;

    @Autowired
    TestRestTemplate template;

    @Before
    public void setup() throws Exception{
        this.url=new URL("http://localhost:"+port+"/");
    }
    @Test
    public void contextLoads() {
        ResponseEntity<String> response=template.getForEntity(url.toString(),String.class);
        System.err.println(response.getBody()+response.getBody().equals("helloSpring!"));
    }
    @Test
    public void demo2(){
        String[] strs={"AC","av","ss","AE","aa","bb"};
        System.err.println(Arrays.toString(strs));
        Arrays.sort(strs,SortBy::compare);
        System.err.println(Arrays.toString(strs));

        List list=Arrays.asList("aa","sss","sssasd");
        System.err.println(list.toString());
    }
    @Test
    public void demo3(){
//        WEEK week=WEEK.Friday;
//        System.err.println(week.toChinese());
        BigDecimal bd=new BigDecimal("11111122334.22222000");
        System.err.println(bd.toString());
    }

    @Test
    public void demo4(){
        String s=null;
        String s1="";
        System.err.println();
    }
}
