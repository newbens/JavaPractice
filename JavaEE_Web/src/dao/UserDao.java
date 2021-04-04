package dao;

import cn.domain.User;

public interface UserDao {

    User findUser(String name);
}
