package com.niuben.springbootcache.mapper;

import com.niuben.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {

    //CRUD
    @Select("select * from employee where id=#{id}")
    Employee findById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    void update(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void delete(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void insert(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    Employee findByName(String lastName);
}
