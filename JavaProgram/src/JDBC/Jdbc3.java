package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//查询数据并封装成对象
public class Jdbc3 {
    public static void main(String[] args) {
        List<Ept> res = findAll();
        System.out.println(res);
    }

    public static List<Ept> findAll() {
        List<Ept> list = new ArrayList<>();
        Statement statement = null;
        Connection con = null;
        ResultSet set = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?serverTimezone=UTC","root","nn8221002**.-");
            String find = "select * from student";
            statement = con.createStatement();
            set = statement.executeQuery(find);
            Ept ept = null;
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString("name");
                int age = set.getInt("age");
                int score = set.getInt("score");
                Date birthday = set.getDate("birthday");
                String sex = set.getString("sex");
                ept = new Ept(id,name,age,score,birthday,sex);
                list.add(ept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
