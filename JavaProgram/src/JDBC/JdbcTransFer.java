package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransFer {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            con = JdbcUtils.getCon();
            //开启事务！！！
            con.setAutoCommit(false);
            String sql = "update student set age = age - ? where id = ?";
            String sql2 = "update student set age = age + ? where id = ?";
            ps = con.prepareStatement(sql);
            ps2 = con.prepareStatement(sql2);
            ps.setInt(1,10);
            ps.setInt(2,1);
            ps2.setInt(1,10);
            ps2.setInt(2,2);
            ps.executeUpdate();
            ps2.executeUpdate();
            //若没有出现异常会执行到这里，提交
            con.commit();
        } catch (Exception e) {
            //如果到这一步，说明需要回滚
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ps,con);
            JdbcUtils.close(ps2,null);
        }
    }
}
