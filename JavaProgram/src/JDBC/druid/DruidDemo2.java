package JDBC.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DruidDemo2 {
    public static void main(String[] args) {
        /*
        �����Ӳ���
         */
        Connection con = null;
        PreparedStatement st = null;
        try {
            //��ȡ����
            con = JdbcUtils.getCon();
            String in = "insert into user values(null ,?,?)";
            //��ȡִ�ж���
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
