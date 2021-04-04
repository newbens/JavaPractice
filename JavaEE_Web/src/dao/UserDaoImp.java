package dao;

import cn.domain.User;
import cn.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImp implements UserDao {
    JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());
    @Override
    public User findUser(String name) {
        String sql = "select * from user where username =? ";
        User user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
        return user;
    }
}
