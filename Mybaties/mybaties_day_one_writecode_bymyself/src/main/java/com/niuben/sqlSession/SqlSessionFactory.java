package com.niuben.sqlSession;


import com.niuben.cfg.Configuration;

public interface SqlSessionFactory {

    /**
     * 打开SqlSession 对象
     * @return
     */
    SqlSession openSession();
}
