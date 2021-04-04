package com.niuben.myblog.mapper;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface TypeMapper {

    @Select("select count(*) from t_type") //查询类型个数
    Integer findAccount();

    @Select("select * from t_type")       //查询所有类型
    List<Type> getTypeList();

    @Select("select * from t_type where name=#{name}") //根据名称查询类型
    Type getTypeByName(String name);

    @Transactional
    @Insert("insert into t_type(name) values(#{name})") //插入新类型
    int saveType(Type type);

    @Select("select * from t_type where id=#{id}") //根据id查询类型
    Type getTypeById(Long id);

    @Transactional
    @Update("update t_type set name=#{name} where id=#{id}") //根据id更新
    void update(Long id,String name);

    @Transactional
    @Delete("delete from t_type where id=#{id}") //根据id删除
    void delete(Long id);


}
