package com.niuben.dao;

import com.niuben.domain.QueryVo;
import com.niuben.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void saveUser(User user);

    void update(User user);

    void delete(Integer id);

    User findById(Integer id);

    List<User> findByName(String name);

    /**
     * 查询总用户数
     */
    int findTotal();

    List<User> findByCondition(User user);

    List<User> findByUids(QueryVo ids);
}
