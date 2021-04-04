package com.niuben.sqlSession;


import com.niuben.cfg.Configuration;
import com.niuben.sqlSession.imp.ImpSqlSessionFactory;
import com.niuben.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建sqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {


    /**
     * 根据参数的字节流文件构建一个SqlSessionFactory工厂
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new ImpSqlSessionFactory(cfg);
    }
}
