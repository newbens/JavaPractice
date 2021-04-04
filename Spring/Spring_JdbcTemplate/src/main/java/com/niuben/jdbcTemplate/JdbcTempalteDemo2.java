package com.niuben.jdbcTemplate;

import com.niuben.domian.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.lang.reflect.AccessibleObject;

public class JdbcTempalteDemo2 {

    /**
     * 基本用法
     */

    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("JdbcTemplate");

    }
}
