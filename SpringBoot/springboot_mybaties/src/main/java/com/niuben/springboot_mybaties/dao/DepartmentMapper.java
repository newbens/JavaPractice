package com.niuben.springboot_mybaties.dao;

import com.niuben.springboot_mybaties.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的Mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department findById(Integer id);

    @Delete("delete from department where id = #{id}")
    void deleteById(Integer id);

    @Options(keyProperty = "id",useGeneratedKeys = true) //设置主键自增加
    @Insert("insert into department(departmentName) values(#{departmentName})")
    void insert(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    void update(Department department);
}
