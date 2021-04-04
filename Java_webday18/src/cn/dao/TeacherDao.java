package cn.dao;

import cn.domain.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> findAll();

    Teacher findTeacherById(int id);

    void Update(Teacher teacher);

}


