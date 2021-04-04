package com.niuben.dao;

import com.niuben.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    //查询所有
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result( id = true,property = "id",column = "id"),
            @Result( property = "username",column = "username"),
            @Result( property = "address",column = "address"),
            @Result( property = "sex",column = "sex"),
            @Result( property = "birthday",column = "birthday"),
            @Result(property = "accounts", column = "id", many=@Many(select = "com.niuben.dao.AccountDao.findByUid",fetchType = FetchType.EAGER))
    })
    List<User> findALl();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=${id}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Integer id);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);
}
