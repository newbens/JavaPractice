package JDBC.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DruidDemo2 {
    public static void main(String[] args) {
        /*
        完成添加操作
         */
        Connection con = null;
        PreparedStatement st = null;
        try {
            //获取连接
            con = JdbcUtils.getCon();
            String in = "insert into user values(null ,?,?)";
            //获取执行对象
            st = con.prepareStatement(in);
            st.setString(1,"123456");
            st.setString(2,"123456");
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(st,con);
        }
    }
}
