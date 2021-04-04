package com.niuben.myblog.service;

import com.niuben.myblog.domain.User;

public interface UserService {

    User check(String username, String password);

}
