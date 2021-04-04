package com.niuben.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 *  1.导入数据库，建表
 *  2.创建javaBean封装数据
 *  3.整合mybaties 操作数据库
 *      1.配置数据源
 *      2.使用注解操作数据库
 *          1.指定mapper接口所在的包
 *  -----------------------体验缓存-------------------------
 *  1.开启基于注解的缓存 @EnableCaching
 *  2.标注缓存注解    @Cacheable  @CacheEvict  @CachePut
 */
@MapperScan("com.niuben.springbootcache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}
