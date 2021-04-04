package cn.service.Imp;

import cn.dao.Imp.TeacherDaoImp;
import cn.dao.TeacherDao;
import cn.domain.Teacher;
import cn.service.TeacherService;

import java.util.List;

public class TeacherServiceImp implements TeacherService {

    TeacherDao teacherDao = new TeacherDaoImp();

    @Override
    public List<Teacher> findAll() {
        List<Teacher> all = teacherDao.findAll();

        return all;
    }

    @Override
    public void UpdateTeacher(Teacher teacher) {
        teacherDao.Update(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacherById = teacherDao.findTeacherById(id);
        return teacherById;

    }
}
