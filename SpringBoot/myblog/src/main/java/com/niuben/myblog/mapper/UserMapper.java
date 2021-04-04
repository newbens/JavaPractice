package com.niuben.myblog.mapper;

import com.niuben.myblog.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface UserMapper {
    @Select("select * from t_user where username=#{username} and password=#{password}")
    User findUser(String username,String password);
    @Insert("insert into t_user(nickname,username,password,email,avatar,createtime) values(#{nickName},#{userName},#{password},#{email},#{avatar},#{createTime})")
    void insert(User user);
    @Select("select password from t_user where username=#{username}")
    String getPasswordByUsername(String username);

    @Update("update t_user set password=#{newPassword} where username=#{username}")
    boolean updatePassword(String username,String newPassword);
}
