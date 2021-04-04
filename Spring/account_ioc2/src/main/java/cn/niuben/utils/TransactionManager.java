package cn.niuben.utils;
//事务管理工具类

import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtils cu;

    public void setCu(ConnectionUtils cu) {
        this.cu = cu;
    }

    //开启事务
    public void begin() {
        try {
            cu.getCon().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交
    public void commit() {
        try {
            cu.getCon().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚
    public void rollback() {
        try {
            cu.getCon().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //释放连接
    public void release() {
        try {
            cu.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cu.remove();
    }
}

