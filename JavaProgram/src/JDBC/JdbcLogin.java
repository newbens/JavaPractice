package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcLogin {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("�������˻���");
        String user = input.next();
        System.out.println("���������룺");
        String password = input.next();
        login(user, password);
    }

    public static void login(String user,String password) throws Exception {
        if (user != null && password != null) {
            Connection con = JdbcUtils.getCon();
            Statement sta = con.createStatement();
            String select = "select * from user where user = "+user;
            ResultSet res = sta.executeQuery(select);
            if (!res.next()) {
                System.out.println("û�д��˻�������");
            }else{
                if (res.getString("password").equals(password)) {
                    System.out.println("��½�ɹ�������");
                }else {
                    System.out.println("�����������");
                }
            }
            JdbcUtils.close(res,sta,con);
        }
    }
}
