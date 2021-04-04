package com.niuben.dao;

import com.niuben.domain.User;

import java.util.List;

public interface UserDao {
    //查询所有用户同时获取用户的所有账户
    List<User> findAll();

    User findById(Integer id);

}
