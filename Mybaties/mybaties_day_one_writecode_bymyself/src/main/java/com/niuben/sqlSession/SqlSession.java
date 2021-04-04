package com.niuben.sqlSession;


/**
 * 与数据库交互的核心类
 */
public interface SqlSession {
    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass  dao的字节码
     * @param <T>  封装类
     * @return  代理对象
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
