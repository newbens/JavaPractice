package cn.dao.Imp;

import cn.dao.StaffDao;
import cn.domain.Admin;
import cn.domain.Staff;
import cn.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
//******************************DAO 主要工作是操作数据库返回数据************************************
public class StaffDaoImp implements StaffDao {
    private JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());
    @Override
    public List<Staff> findAll() {   //查询数据库所有信息
        //操作数据库
        String findall = "select * from staff";
        List<Staff> all = jt.query(findall, new BeanPropertyRowMapper<Staff>(Staff.class));
        return all;
    }

    @Override
    public Admin getUserPassword(Admin loginAdmin) {  //验证身份
        try {
            String sql = "select * from admin where username = ? and password = ?";
            System.out.println(loginAdmin.getUser()+"  "+loginAdmin.getPassword());
            Admin admin = jt.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),loginAdmin.getUser(),loginAdmin.getPassword());
            return admin;
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public void addStaff(Staff staff) {    //添加数据
        String sql = "insert into staff values(null,?,?,?,?,?,?)";
        jt.update(sql, staff.getName(), staff.getGender(), staff.getAge(), staff.getAddress(),staff.getPhone(),staff.getEmail());

    }

    @Override
    public void delStaff(int id) {   //删除数据
        String sql = "delete from staff where id = ?";
        jt.update(sql, id);
    }

    @Override
    public Staff findOne(int id) {   //查找
        String sql = "select * from staff where id = ? ";
        Staff staff = jt.queryForObject(sql, new BeanPropertyRowMapper<Staff>(Staff.class), id);
        return staff;
    }

    @Override
    public void update(Staff staff) {   //更新
        String sql = "update staff set gender = ?,age = ?,address = ?,phone = ?,email = ? where id = ?";
        jt.update(sql, staff.getGender(), staff.getAge(), staff.getAddress(), staff.getPhone(), staff.getEmail(), staff.getId());
    }

    @Override
    public int findInfoSum(Map<String, String[]> parameterMap) {    //求总信息
        String sql = "select count(*) from staff where 1 = 1";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sql);
        //参数集合
        List<Object> list = new ArrayList();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            String s = stringEntry.getValue()[0];
            //拼接sql语句
            if (s != null && !"".equals(s)) {
                if ("currentPage".equals(stringEntry.getKey()) || "rows".equals(stringEntry.getKey())) {
                    continue;
                }
                stringBuffer.append(" and " + stringEntry.getKey() + " like ? ");
                list.add("%"+s+"%");
            }
        }
        return jt.queryForObject(stringBuffer.toString(), Integer.class,list.toArray());  //返回查询出数据的总条数
    }

    @Override
    public List<Staff> findByPage(int begin, int row, Map<String, String[]> parameterMap) {   //多条数据查询
        String sql = "select * from staff where 1 = 1";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sql);
        //参数集合
        List<Object> list = new ArrayList();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            String s = stringEntry.getValue()[0];
            if (s != null && !"".equals(s)) {
                if ("currentPage".equals(stringEntry.getKey()) || "rows".equals(stringEntry.getKey())) {
                    continue;
                }
                stringBuffer.append(" and " + stringEntry.getKey() + " like ? ");
                list.add("%"+s+"%");
            }
        }
        stringBuffer.append(" limit ? , ?");
        list.add(begin);
        list.add(row);
        System.out.println(stringBuffer.toString());
        System.out.println(Arrays.toString(list.toArray()));
        return jt.query(stringBuffer.toString(), new BeanPropertyRowMapper<Staff>(Staff.class),list.toArray());//把查询出的数据分装成对象返回
    }


}
