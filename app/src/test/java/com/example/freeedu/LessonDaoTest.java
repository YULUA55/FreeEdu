package com.example.freeedu;

import android.icu.util.LocaleData;

import org.junit.Before;
import org.junit.Test;

import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Lesson;
import com.example.freeedu.entities.Teacher;
import com.example.freeedu.dao.LessonDao;

import static org.junit.Assert.*;

public class LessonDaoTest {
    LessonDao lessonDao;

    @Before
    public void globalSetup() {
        lessonDao = new LessonDao();

    }

    @Test
    public void negativeEquals() {
        Teacher teacher = new Teacher("Lida", "Ivanova", "lil@mail.ru");
        Course course = new Course("Math_basic", "For beginner", teacher);
        Lesson lesson = new Lesson(course, "functions");
        Lesson otherLesson = new Lesson(course, "functions");
        assertEquals(lesson, otherLesson);
    }

    @Test
    public void gettingCourseFromLesson() {
        Teacher teacher = new Teacher("Lida", "Ivanova", "lil@mail.ru");
        Course course = new Course("Math_basic", "For beginner", teacher);
        Lesson lesson = new Lesson(course, "function");
        Lesson transformLesson = lessonDao.getEntity("{\"course\":{\"name\":\"Math_basic\",\"description\":\"For beginner\",\"teacher\":{\"name\":\"Lida\",\"surname\":\"Ivanova\",\"email\":\"lil@mail.ru\"}},\"description\":\"function\"}");
        assertEquals(course, transformLesson.getCourse());
        assertEquals(lesson, transformLesson);
    }

}

