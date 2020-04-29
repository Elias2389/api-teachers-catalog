package com.ae.teachercatalog.dao;


import com.ae.teachercatalog.model.Teacher;

import java.util.List;

public interface TeacherDao {

    void saveTeacher(final Teacher teacher);

    List<Teacher> findAllTeachers();

    void deleteTeacher(final Long idTeacher);

    void updateTeacher(final Teacher teacher);

    Teacher findTeacherByName(final String name);

    Teacher findTeacherById(final Long idTeacher);
}
