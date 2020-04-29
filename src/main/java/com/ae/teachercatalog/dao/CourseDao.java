package com.ae.teachercatalog.dao;

import com.ae.teachercatalog.model.Course;

import java.util.List;

public interface CourseDao {

    void saveCourse(final Course course);

    List<Course> findAllCourses();

    void deleteCourse(final Long idCourse);

    void updateCourse(final Course course);

    Course findCourserByName(final String name);

    Course findCourseById(final Long idCourse);

    List<Course> findCourseByIdTeacher(final Long idTeacher);
}
