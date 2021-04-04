package cn.service;

import cn.domain.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    void UpdateTeacher(Teacher teacher);

    Teacher findTeacherById(int id);
}
