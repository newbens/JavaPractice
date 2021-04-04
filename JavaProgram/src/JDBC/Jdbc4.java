package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class    Jdbc4 {
    public static void main(String[] args) throws SQLException {
        Connection con = JdbcUtils.getCon(); //获取连接
        Statement sta = con.createStatement(); //创建执行对象
        String find = "select * from student";
        ResultSet set = sta.executeQuery(find);
        while (set.next()) {
            System.out.println(set.getString("name"));
        }
        JdbcUtils.close(set,sta,con); //关闭

    }
}
