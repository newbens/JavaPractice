package JDBC;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

//������
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String passwd;
    private static String driver;

    static {
        //�����ļ�
        try {
            Properties pro = new Properties();
            //��ȡ·��
            ClassLoader cl = JdbcUtils.class.getClassLoader();
            //��ȡ����·��
            URL u = cl.getSystemResource("jdbc.properties");
            //ת��
            String path = u.getPath();
            pro.load(new FileReader(path)); //����·��
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            passwd = pro.getProperty("password");
            driver = pro.getProperty("driver");
            try {
                Class.forName(driver);   //�ھ�̬�����ע�ᣬֻҪ����ؾͲ������ֶ�ע�ᡣ
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getCon() throws SQLException {
        //������ʵ���������ݿ�
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
