package JDBC.JdbcTemplate;

import JDBC.Ept;
import JDBC.druid.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcT2 {

    private JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());

    // ***************************增删改操作**************************//
    @Test
    public void test1() {
        String sql = "update student set age = 22 where id = 1";
        int res = jt.update(sql);
        System.out.println(res);
    }

    @Test
    public void test2() {
        String sql = "insert into student (id,name,age,score,sex)values(4,'Yao',42,100,'男')";
        int res = jt.update(sql);
        System.out.println(res);
    }

    @Test
    public void test3() {
        String sql = "delete from student where name = 'Yao'";
        int res = jt.update(sql);
        System.out.println(res);
    }

    //*****************************查询操作*******************************//
    @Test
    //**************************查询的结果集长度只能是1********************//
    public void test4() {
        String sql = "select * from student where id = ?";
        Map<String, Object> map = jt.queryForMap(sql, 1);
        System.out.println(map);
    }

    @Test
    public void test5() {
        String sql = "select * from student";
        List<Map<String, Object>> maps = jt.queryForList(sql);
        for (Map<String, Object> maps1 : maps) {
            System.out.println(maps1);
        }
    }

    //*************************查询所有数据并封装成对象**********************//
    @Test
    public void test6() {
        String sql = "select * from student";
        List<Ept> list = jt.query(sql, new RowMapper<Ept>() {
            @Override
            public Ept mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt("id");
               String name =  rs.getString("name");
                int age = rs.getInt("age");
                int score = rs.getInt("score");
                String sex = rs.getString("sex");
                Ept ept = new Ept(id,name,age,score,null,sex);
                return ept;
            }
        });
        System.out.println(list);
    }

//    @Test1             返回数组的第二种方法！！！自动封装
//    public void test6_2() {
//        String sql = "select * from student";
//        List<Ept> list = jt.query(sql, new BeanPropertyRowMapper<Ept>(Ept.class));
//        System.out.println(list);
//    }

    @Test
    public void test7() {
        String sql = "select count(id) from student";
        Long sum = jt.queryForObject(sql, long.class);
        System.out.println(sum);
    }

}
