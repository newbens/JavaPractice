package com.niuben.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 事务配置类
 */

public class TransactionConfig {
    /**
     * 创建事务管理器对象
     * @param dataSource  数据源
     * @return 返回事务管理器对象
     */
    @Bean("transactionManager")
    public PlatformTransactionManager getTm(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
