package com.ae.teachercatalog.dao;

import com.ae.teachercatalog.model.Teacher;

import java.util.List;

public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

    @Override
    public void saveTeacher(final Teacher teacher) {
        getSession().persist(teacher);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return getSession().createQuery("from Teacher ").list();
    }

    @Override
    public void deleteTeacher(Long idTeacher) {
        final Teacher teacher = (Teacher) findTeacherById(idTeacher);
        if (teacher != null) {
            getSession().delete(teacher);
        }
    }

    @Override
    public void updateTeacher(final Teacher teacher) {
        getSession().update(teacher);
    }

    @Override
    public Teacher findTeacherByName(final String name) {
        return (Teacher) getSession()
                .createQuery("from Teacher where name = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public Teacher findTeacherById(final Long idTeacher) {
        return (Teacher) getSession().get(Teacher.class, idTeacher);
    }
}
