package com.ae.teachercatalog.service;

import com.ae.teachercatalog.dao.CourseDao;
import com.ae.teachercatalog.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void saveCourse(final Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseDao.findAllCourses();
    }

    @Override
    public void deleteCourse(final Long idCourse) {
        courseDao.deleteCourse(idCourse);
    }

    @Override
    public void updateCourse(final Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Course findCourserByName(final String name) {
        return courseDao.findCourserByName(name);
    }

    @Override
    public Course findCourseById(final Long idCourse) {
        return courseDao.findCourseById(idCourse);
    }

    @Override
    public List<Course> findCourseByIdTeacher(final Long idTeacher) {
        return courseDao.findCourseByIdTeacher(idTeacher);
    }
}
