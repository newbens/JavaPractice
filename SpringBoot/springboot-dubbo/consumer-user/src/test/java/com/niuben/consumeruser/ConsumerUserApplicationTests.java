package com.niuben.consumeruser;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.niuben.consumeruser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@EnableDubbo
@SpringBootTest
class ConsumerUserApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.hello();
    }

}
