package com.niuben.springbootcache.controller;

import com.niuben.springbootcache.bean.Employee;
import com.niuben.springbootcache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/findemp/{id}")
    public Employee findEmp(@PathVariable("id") Integer id) {
        return  empService.getEmp(id);
    }

    @GetMapping("/updateemp")
    public Employee update(Employee employee) {
        return empService.updateEmp(employee);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        empService.deleteEmp(id);
        return id+"";
    }

    @GetMapping("/findbyname/{lastName}")
    public Employee findByName(@PathVariable("lastName") String lastName) {
        return  empService.findByName(lastName);
    }
}
