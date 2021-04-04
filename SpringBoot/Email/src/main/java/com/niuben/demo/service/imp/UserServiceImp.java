package com.niuben.demo.service.imp;

import com.niuben.demo.domain.User;
import com.niuben.demo.mapper.UserMapper;
import com.niuben.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(String username,String password) {
        return userMapper.findUser(username,password);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }
}
