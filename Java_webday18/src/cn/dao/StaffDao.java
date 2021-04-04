package cn.dao;

import cn.domain.Admin;
import cn.domain.Staff;

import java.util.List;
import java.util.Map;

public interface StaffDao {
    List<Staff> findAll();

    Admin getUserPassword(Admin loginAdmin);

    void addStaff(Staff staff);

    void delStaff(int id);

    Staff findOne(int id);

    void update(Staff staff);

    int findInfoSum(Map<String, String[]> parameterMap);

    List<Staff> findByPage(int begin, int row, Map<String, String[]> parameterMap);
}
