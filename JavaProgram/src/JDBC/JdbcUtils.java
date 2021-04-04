package JDBC;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

//工具类
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String passwd;
    private static String driver;

    static {
        //加载文件
        try {
            Properties pro = new Properties();
            //获取路径
            ClassLoader cl = JdbcUtils.class.getClassLoader();
            //获取绝对路径
            URL u = cl.getSystemResource("jdbc.properties");
            //转换
            String path = u.getPath();
            pro.load(new FileReader(path)); //绝对路径
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            passwd = pro.getProperty("password");
            driver = pro.getProperty("driver");
            try {
                Class.forName(driver);   //在静态代码块注册，只要类加载就不用再手动注册。
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getCon() throws SQLException {
        //不传参实现连接数据库
        return DriverManager.getConnection(url, user, passwd);

    }

    public static void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
