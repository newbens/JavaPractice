package com.niuben.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置类 相当于bean.xml
 */
@Configuration //指定当前为配置类
@ComponentScan("com.niuben") //扫描范围
@Import({JdbcConfigration.class,TransactionConfig.class}) //导入配置文件
@PropertySource("jdbcConfig.properties") //配置文件位置
@EnableTransactionManagement  //开启注解支持
public class SpringConfigration {



}
