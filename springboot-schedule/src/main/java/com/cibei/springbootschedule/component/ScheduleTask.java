package com.cibei.springbootschedule.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *
 * @author leishufeng
 * @date 2019/07/12 14:03
 */
@Component
public class ScheduleTask {
    private static final Logger LOGGER= LoggerFactory.getLogger(ScheduleTask.class);

    private SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void cycleTask(){
        LOGGER.info("now is:"+format.format(new Date()));
    }
}
