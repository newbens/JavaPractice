package cn.service;

import cn.domain.Admin;
import cn.domain.PageBean;
import cn.domain.Staff;

import java.util.List;
import java.util.Map;

//用户管理接口
public interface StaffService {
    List<Staff> findAll();

    Admin login(Admin loginAdmin);

    void addStaff(Staff staff);

    void delStaff(int id);

    Staff findOne(int id);

    void updateStaff(Staff staff);

    void delSelect(int[] ids);

    PageBean<Staff> findStaffPage(String currentPage, String rows, Map<String, String[]> parameterMap);   //分页查询

}
