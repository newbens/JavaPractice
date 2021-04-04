package com.niuben.springboot01helloword;

import com.niuben.springboot01helloword.bean.Persom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBoot01HellowordApplicationTests {

    @Autowired
    Persom persom;
    @Autowired
    ApplicationContext ioc;

    @Test
    public void test() {
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }


    @Test
    void contextLoads() {
        System.out.println(persom);
    }

}
