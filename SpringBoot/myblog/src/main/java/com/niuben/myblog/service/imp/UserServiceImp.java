package com.niuben.myblog.service.imp;

import com.niuben.myblog.mapper.UserMapper;
import com.niuben.myblog.domain.User;
import com.niuben.myblog.service.UserService;
import com.niuben.myblog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User check(String username, String password) {
        User user = userMapper.findUser(username, password);
        return user;
    }

    @Override
    public User insert(User user) {
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return user;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return userMapper.getPasswordByUsername(username);
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        return userMapper.updatePassword(username, newPassword);
    }


}
