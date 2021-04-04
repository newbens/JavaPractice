package com.niuben.springboot_mybaties.dao;

import com.niuben.springboot_mybaties.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper  //将接口装配到容器中
public interface EmployeeMapper {

    public Employee findById(Integer id);

    public void insert(Employee employee);
}
