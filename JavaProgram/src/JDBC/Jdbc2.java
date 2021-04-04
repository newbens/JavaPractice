package JDBC;
import java.sql.*;
public class Jdbc2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?serverTimezone=UTC","root","nn8221002**.-");
//            String insert = "insert into student(id,name,age,score,sex) values(1,'James',35,98,'ÄÐ')";
//            String update = "update student set age = 35 where id = 2";
            String delete = "delete from student where id = 2";
            String get = "select * from student";
            statement = connection.createStatement();
//            int res = statement.executeUpdate(delete);
            set = statement.executeQuery(get);
            while (set.next()) {
                System.out.println(set.getString("name")+" "+set.getInt("age"));
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
