package test.cn.dao;

import dao.UserDao333;
import cn.domain.User;
import org.junit.Test;

public class TestUserDao {
    @Test
    public void testLogin() {
        User user = new User("123456","123456","213");
        UserDao333 ud = new UserDao333();
        User user1 = ud.userLogin(user);
        System.out.println(user1);
    }
}
