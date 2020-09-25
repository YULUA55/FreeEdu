package com.example.freeedu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.freeedu.dao.CourseDаo;
import com.example.freeedu.dao.TeacherDao;
import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Teacher;

import java.util.ArrayList;
import java.util.Collections;

public class TeacherDaoTest {
    TeacherDao teacherDao;
    CourseDаo courseDаo;

    @Before
    public void globalSetup() {
        teacherDao = new TeacherDao();
        courseDаo = new CourseDаo();

    }

    @Test
    public void rightEquals() {
        Teacher teacher = new Teacher("Uli", "Alenkova", "uli@mail.ru");
        Teacher sameTeacher = new Teacher("Uli", "Alenkova", "uli@mail.ru");
        assertEquals(teacher, sameTeacher);
    }

    @Test
    public void rightTranslate() {
        Teacher teacher = new Teacher("Uli", "Alenkova", "uli@mail.ru");
        System.out.println(teacher.toString());
        Teacher teacher2 = teacherDao.getEntity("{ \"name\":\"Uli\",\"surname\":\"Alenkova\",\"email\":\"uli@mail.ru\" }");

        assertEquals(teacher, teacher2);
    }

    @Test
    public void gettingTeachersCourses(){
        Teacher teacher = new Teacher("Uli", "Alenkova", "uli@mail.ru");
        Course[] transformCourses = courseDаo.getAll(
                "[{\"name\":\"Math_basic\",\"description\":\"For beginner\"},{\"name\":\"Programming_basic\",\"description\":\"For beginner\"},{\"name\":\"AI_basic\",\"description\":\"For beginner\"}]");

        ArrayList list = new ArrayList();
        Collections.addAll(list,transformCourses);
        teacher.setCourses(list);
        assertEquals(3,teacher.getCourses().size());

    }
}