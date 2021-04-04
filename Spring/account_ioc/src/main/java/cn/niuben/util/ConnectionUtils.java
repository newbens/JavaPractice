package cn.niuben.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public Connection getCon() {
        try {
            Connection con = threadLocal.get();
            if (con == null) {
                //创建连接
                con = dataSource.getConnection();
                threadLocal.set(con);
            }
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void conRemove() {
        threadLocal.remove();  //解绑
    }


}
