package com.niuben.demo.service;

import com.niuben.demo.domain.User;

public interface UserService {



    User findUser(String username,String password);

    void insertUser(User user);

    User findUserByEmail(String email);
}
