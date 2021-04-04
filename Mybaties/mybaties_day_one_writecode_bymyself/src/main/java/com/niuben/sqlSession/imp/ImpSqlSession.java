package com.niuben.sqlSession.imp;


import com.niuben.cfg.Configuration;
import com.niuben.sqlSession.SqlSession;
import com.niuben.sqlSession.SqlSessionFactory;
import com.niuben.sqlSession.proxy.MapperProxy;
import com.niuben.utils.DataSourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 */
public class ImpSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public ImpSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     *
     * @param daoInterfaceClass dao的字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Object object = Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
        return (T) object;
    }


    /**
     * 关闭资源
     */
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
