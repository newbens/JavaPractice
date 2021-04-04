package JDBC.JdbcTemplate;
//JdbcTemplate是Spring框架对jdbc的一种封装，使用更加简便
import JDBC.druid.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcT {
    public static void main(String[] args) {
        //传入参数为DataSocre类型
        JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());
        String sql = "update user set password = '123' where user = ?";
        int count = jt.update(sql, "123456");
        System.out.println(count);
    }
}
