package com.niuben.demo.mapper;

import com.niuben.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    User findUser(String username,String password);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insertUser(User user);

    @Select("select * from user where username=#{username}")
    User findUserByEmail(String username);
}
