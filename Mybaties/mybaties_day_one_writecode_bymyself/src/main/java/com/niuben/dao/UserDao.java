package com.niuben.dao;


import com.niuben.domain.User;

import java.util.List;

public interface UserDao {


    List<User> findAll();
}
