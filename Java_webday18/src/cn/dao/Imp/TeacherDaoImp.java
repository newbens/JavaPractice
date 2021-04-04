package cn.dao.Imp;

import cn.dao.TeacherDao;
import cn.domain.Teacher;
import cn.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeacherDaoImp implements TeacherDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDs());

    @Override
    public List<Teacher> findAll() {
        String sql = "select * from teacher";
        List<Teacher> all = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
        return all;
    }

    @Override
    public Teacher findTeacherById(int id) {
        String sql = "select * from teacher where id = ?";
        Teacher teacher = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), id);
        return teacher;
    }

    @Override
    public void Update(Teacher teacher) {
        String sql = "update teacher set name = ?,age = ?,gender = ?,email = ?,address = ?,college = ? where id = ?";
        jdbcTemplate.update(sql, teacher.getName(), teacher.getAge(),teacher.getGender(),teacher.getEmail(), teacher.getAddress(), teacher.getCollege(), teacher.getId());

    }
}
