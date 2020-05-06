package com.ae.teachercatalog.service;

import com.ae.teachercatalog.dao.TeacherDao;
import com.ae.teachercatalog.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public void saveTeacher(final Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherDao.findAllTeachers();
    }

    @Override
    public void deleteTeacher(final Long idTeacher) {
        teacherDao.deleteTeacher(idTeacher);
    }

    @Override
    public void updateTeacher(final Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByName(final String name) {
        return teacherDao.findTeacherByName(name);
    }

    @Override
    public Teacher findTeacherById(final Long idTeacher) {
        return teacherDao.findTeacherById(idTeacher);
    }
}
