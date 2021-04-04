package com.niuben.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTempalteDemo1 {

    /**
     * 基本用法
     */

    public static void main(String[] args) {
        //准备数据源：spring内置数据源
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("com.mysql.jdbc.Driver");
        dm.setUrl("jdbc:mysql://localhost:3306/java?serverTimezone=Asia/Shanghai");
        dm.setUsername("root");
        dm.setPassword("nn8221002**.-");
        JdbcTemplate jt = new JdbcTemplate(dm);
        jt.execute("insert into account(name,money) values ('ddd',5000)");
    }
}
