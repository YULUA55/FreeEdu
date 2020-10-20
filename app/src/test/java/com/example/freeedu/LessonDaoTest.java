package com.example.freeedu;

import org.junit.Before;
import org.junit.Test;

import com.example.freeedu.entities.Lesson;
import com.example.freeedu.dao.LessonDao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

public class LessonDaoTest {
    LessonDao lessonDao;

    @Before
    public void globalSetup() {
        lessonDao = new LessonDao();

    }

    @Test
    public void negativeEquals() {

        Lesson lesson = new Lesson("123", LocalDateTime.of(2017, Month.JULY, 9, 11, 6, 22));
        Lesson otherLesson = new Lesson("123", LocalDateTime.of(2017, Month.JULY, 9, 11, 6, 22));
        assertEquals(lesson, otherLesson);
    }

    @Test
    public void positiveEquals() {

        Lesson otherLesson = lessonDao.getEntity("{ \"description\":\"123\",\"date\":\"2017-07-09T09:11:06\"}");

        Lesson[] lessons = lessonDao.getAll("[{ \"description\":\"123\",\"date\":\"2017-07-09T09:11:06\"}]");
        for (int i=0; i< lessons.length ;i++){
            System.out.println(lessons[i].toString());
        }

    }

}

