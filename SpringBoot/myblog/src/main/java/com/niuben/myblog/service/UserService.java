package com.niuben.myblog.service;

import com.niuben.myblog.domain.User;

public interface UserService {

    User check(String username, String password);

    User insert(User user);

    String getPasswordByUsername(String username);

    boolean updatePassword(String username, String newPassword);
}
