package com.ae.teachercatalog.dao;

import com.ae.teachercatalog.model.Course;

import java.util.List;

public class CourseDaoImpl extends AbstractSession implements CourseDao {
    @Override
    public void saveCourse(final Course course) {
        getSession().persist(course);
    }

    @Override
    public List<Course> findAllCourses() {
        return getSession().createQuery("from Course").list();
    }

    @Override
    public void deleteCourse(final Long idCourse) {
        final Course course = findCourseById(idCourse);
        if (course != null) {
            getSession().delete(course);
        }
    }

    @Override
    public void updateCourse(final Course course) {
        getSession().update(course);
    }

    @Override
    public Course findCourserByName(final String name) {
        return (Course) getSession()
                .createQuery("from Course where name = :name")
                .setParameter("name", name);
    }

    @Override
    public Course findCourseById(final Long idCourse) {
        return (Course) getSession().get(Course.class, idCourse);
    }

    @Override
    public List<Course> findCourseByIdTeacher(Long idTeacher) {
        return getSession()
                .createQuery(
                        "from Course c join c.teacher t where t.idTeacher = :idTeacher")
                .setParameter("idTeacher", idTeacher).list();
    }
}
