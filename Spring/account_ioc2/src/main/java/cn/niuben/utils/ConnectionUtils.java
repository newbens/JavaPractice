package cn.niuben.utils;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal();

    private DataSource ds;
    //用于注入
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public Connection getCon() {
        //1.先从threadLocal获取
        Connection connection = threadLocal.get();
        //2.判断当前线程是否有连接
        if (connection == null) {
            try {
                //3.从数据源获取连接，
                connection = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //存入threadLocal
            threadLocal.set(connection);
        }
        return connection;
    }
//线程和连接解绑
    public void remove() {
        threadLocal.remove();
    }
}

