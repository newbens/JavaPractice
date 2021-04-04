package com.niuben.myblog.mapper;

import com.niuben.myblog.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from t_user where username=#{username} and password=#{password}")
    User findUser(String username,String password);
}
