package com.niuben.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //定时器
    @Scheduled(cron = "0 * * * * MON-FRI")//五个点分别对应秒，分，时，月，年。
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")  每分钟的0，1，2，3，4秒执行
//    @Scheduled(cron = "0/2 * * * * MON-FRI")  每四秒执行一次
    public void hello() {
        System.out.println("hello");
    }
}
