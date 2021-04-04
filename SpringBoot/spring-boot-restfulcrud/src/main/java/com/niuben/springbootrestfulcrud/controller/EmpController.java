package com.niuben.springbootrestfulcrud.controller;

import com.niuben.springbootrestfulcrud.dao.DepartmentDao;
import com.niuben.springbootrestfulcrud.dao.EmployeeDao;
import com.niuben.springbootrestfulcrud.domain.Department;
import com.niuben.springbootrestfulcrud.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //得到所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dep", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";//这里不能直接emps因为视图解析器只解析静态文件夹下面的
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dep", departments);
        return "emp/modify";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
