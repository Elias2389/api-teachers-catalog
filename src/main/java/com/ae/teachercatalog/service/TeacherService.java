package com.ae.teachercatalog.service;

import com.ae.teachercatalog.model.Teacher;

import java.util.List;

public interface TeacherService {

    void saveTeacher(final Teacher teacher);

    List<Teacher> findAllTeachers();

    void deleteTeacher(final Long idTeacher);

    void updateTeacher(final Teacher teacher);

    Teacher findTeacherByName(final String name);

    Teacher findTeacherById(final Long idTeacher);
}
