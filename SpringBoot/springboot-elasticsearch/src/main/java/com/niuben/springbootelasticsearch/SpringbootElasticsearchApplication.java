package com.niuben.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *   springboot默认支持两种技术与ES交互
 *   1.Jest默认不生效 需要导包
 *   2.springData Elasticsearch
 *
 */
@SpringBootApplication
public class SpringbootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearchApplication.class, args);
    }

}
