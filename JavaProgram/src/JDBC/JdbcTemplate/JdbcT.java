package JDBC.JdbcTemplate;
//JdbcTemplate��Spring��ܶ�jdbc��һ�ַ�װ��ʹ�ø��Ӽ��
import JDBC.druid.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcT {
    public static void main(String[] args) {
        //�������ΪDataSocre����
        JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());
        String sql = "update user set password = '123' where user = ?";
        int count = jt.update(sql, "123456");
        System.out.println(count);
    }
}
