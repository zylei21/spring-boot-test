package com.cibei.springbootasync.service;

import com.cibei.springbootasync.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 15:07
 */
@Service
public class GithubLookupService {
    private static final Logger LOGGER= LoggerFactory.getLogger(GithubLookupService.class);
    private  RestTemplate template;

    public GithubLookupService(RestTemplateBuilder builder){
        this.template=builder.build();
    }

    @Async
    public Future<User> findUser(String user) throws InterruptedException{
        LOGGER.info("looking up"+user);

        String url = String.format("https://api.github.com/users/%s", user);
        User user1=template.getForObject(url,User.class);
        Thread.sleep(1000L);
        return new AsyncResult<>(user1);
    }
}
