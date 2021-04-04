package com.niuben.springboottask.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsycService {

    @Async//说明方法是异步的 -------------------此注解需要生效，就要在主程序入口加上注解EnableAsyc
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中");

    }

}
