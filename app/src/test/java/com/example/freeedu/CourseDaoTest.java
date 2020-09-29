package com.example.freeedu;

import org.junit.Before;
import org.junit.Test;

import com.example.freeedu.dao.CourseDаo;
import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Teacher;


import static org.junit.Assert.*;

public class CourseDaoTest {
    CourseDаo courseDao;

    @Before
    public void globalSetup() {
        courseDao = new CourseDаo();

    }

    @Test
    public void rightEquals() {
        Teacher teacher = new Teacher("Lida","Ivanova","lil@mail.ru");
        Course course = new Course("Math_basic", "For beginner");
        Course sameCourse = new Course("Math_basic", "For beginner");
        assertEquals(course, sameCourse);
    }

    @Test
    public void rightTransformCourse() {
        Teacher teacher = new Teacher("Lida","Ivanova","lil@mail.ru");
        Course course = new Course("Math_basic", "For beginner");
        Course transformCourse = courseDao.getEntity("{\"name\":\"Math_basic\",\"description\":\"For beginner\"}");
        assertEquals(course, transformCourse);
    }

    @Test
    public void rightGettingAllCourses() {
        Teacher teacher = new Teacher("Lida","Ivanova","lil@mail.ru");
        Course course1 = new Course("Math_basic", "For beginner");
        Course course2 = new Course("Programming_basic", "For beginner");
        Course course3 = new Course("AI_basic", "For beginner");
        Course[] courses = new Course[3];
        courses[0] = course1;
        courses[1] = course2;
        courses[2] = course3;
        Course[] transformCourses = courseDao.getAll(
                "[{\"name\":\"Math_basic\",\"description\":\"For beginner\"},{\"name\":\"Programming_basic\",\"description\":\"For beginner\"},{\"name\":\"AI_basic\",\"description\":\"For beginner\"}]");

        assertArrayEquals(courses, transformCourses);
    }

}

