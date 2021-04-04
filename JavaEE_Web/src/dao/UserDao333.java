package dao;

import cn.domain.User;
import cn.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao333 {
    public JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());
    /**
     * 登陆方法
     * @param loginUser 只有用户名和登陆密码
     * @return 返回用户全部信息
     */
    public User userLogin(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            //User必须有空的构造方法
            User user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }
}
