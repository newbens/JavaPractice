package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc {
    public static void main(String[] args) throws Exception{
        //ע������   mysql5����Բ���д
        Class.forName("com.mysql.jdbc.Driver");
        //��ȡ���Ӷ���
        Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?serverTimezone=UTC","root","nn8221002**.-");
        //����sql���
        String update = "update student set age = 23 where id = 1";
        //��ȡִ�ж���
        Statement statement = conn.createStatement();
        int res = statement.executeUpdate(update);
        System.out.println(res);
        //�ر���Դ
        statement.close();
        conn.close();
    }
}
