package com.niuben.springboot_mybaties.controller;


import com.niuben.springboot_mybaties.bean.Department;
import com.niuben.springboot_mybaties.bean.Employee;
import com.niuben.springboot_mybaties.dao.DepartmentMapper;
import com.niuben.springboot_mybaties.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class DepController {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dep")
    public Department saveDep(Department department) {
        departmentMapper.insert(department);
        return department;
    }

    @GetMapping("/dep/{id}")
    public Department findDep(@PathVariable("id") Integer id) {
        return departmentMapper.findById(id);
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.findById(id);
    }

    @GetMapping("/empinsert")
    public Employee insert(Employee employee) {
        employeeMapper.insert(employee);
        return employee;
    }
}
