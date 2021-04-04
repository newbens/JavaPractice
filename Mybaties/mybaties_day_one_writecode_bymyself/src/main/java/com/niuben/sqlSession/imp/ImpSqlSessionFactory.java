package com.niuben.sqlSession.imp;

import com.niuben.cfg.Configuration;
import com.niuben.sqlSession.SqlSession;
import com.niuben.sqlSession.SqlSessionFactory;

import java.sql.Connection;

public  class ImpSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public ImpSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 创建新的操作数据库对象
     * @return
     */

    public SqlSession openSession() {
        return new ImpSqlSession(cfg);
    }


}
