package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc {
    public static void main(String[] args) throws Exception{
        //注册驱动   mysql5后可以不用写
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象
        Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?serverTimezone=UTC","root","nn8221002**.-");
        //定义sql语句
        String update = "update student set age = 23 where id = 1";
        //获取执行对象
        Statement statement = conn.createStatement();
        int res = statement.executeUpdate(update);
        System.out.println(res);
        //关闭资源
        statement.close();
        conn.close();
    }
}
