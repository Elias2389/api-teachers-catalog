package com.ae.teachercatalog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @Column(name = "id_teacher")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_teacher")
    private Set<TeacherSocialMedia> teachersSocialMedia;

    public Teacher() {
        super();
    }

    public Teacher(String name, String avatar) {
        super();
        this.name = name;
        this.avatar = avatar;
    }

    public Set<TeacherSocialMedia> getTeachersSocialMedia() {
        return teachersSocialMedia;
    }

    public void setTeachersSocialMedia(Set<TeacherSocialMedia> teachersSocialMedia) {
        this.teachersSocialMedia = teachersSocialMedia;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
