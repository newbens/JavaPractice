package cn.service.Imp;

import cn.dao.Imp.StaffDaoImp;
import cn.dao.StaffDao;
import cn.domain.Admin;
import cn.domain.PageBean;
import cn.domain.Staff;
import cn.service.StaffService;

import java.util.List;
import java.util.Map;

public class StaffServiceImp implements StaffService {
    private StaffDao sd = new StaffDaoImp();

    @Override
    public List<Staff> findAll() {
        //业务逻辑层   调用Dao查询想要的信息，返回给控制层。
        return sd.findAll();
    }

    @Override
    public Admin login(Admin loginAdmin) {
        return sd.getUserPassword(loginAdmin);
    }

    @Override
    public void addStaff(Staff staff) {
        sd.addStaff(staff);
    }

    @Override
    public void delStaff(int id) {
        sd.delStaff(id);
    }

    @Override
    public Staff findOne(int id) {
        return sd.findOne(id);
    }

    @Override
    public void updateStaff(Staff staff) {
        sd.update(staff);
    }

    @Override
    public void delSelect(int[] ids) {
        for (int id : ids) {
            sd.delStaff(id);
        }
    }

    @Override
    public PageBean<Staff> findStaffPage(String currentPage, String rows, Map<String, String[]> parameterMap) {
        int currentP = Integer.parseInt(currentPage);
        int row = Integer.parseInt(rows);
        PageBean<Staff> pageBean = new PageBean<>();
        //设置参数
        pageBean.setCurrentPage(currentP);
        pageBean.setRows(row);
        //调用dao 查询记录数
        int infoSum = sd.findInfoSum(parameterMap);
        pageBean.setInfoSum(infoSum);
        //查询数据
        int begin = (currentP-1)*row;
        List<Staff> list = sd.findByPage(begin,row,parameterMap);
        pageBean.setList(list);
        //计算总页码
        int pageSum = infoSum % row == 0 ? infoSum / row : infoSum / row + 1;
        pageBean.setPageSum(pageSum);
    return pageBean;
    }


}
