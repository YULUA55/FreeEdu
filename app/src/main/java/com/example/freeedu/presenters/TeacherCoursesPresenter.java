package com.example.freeedu.presenters;

import com.example.freeedu.connection.AbstractAsyncTask;
import com.example.freeedu.connection.Request;
import com.example.freeedu.dao.CourseDаo;
import com.example.freeedu.entities.Course;
import com.example.freeedu.model.TeacherCoursesModel;
import com.example.freeedu.views.TeacherCoursesView;

import java.util.ArrayList;
import java.util.Collections;

public class TeacherCoursesPresenter implements BasePresenter {

    private TeacherCoursesView teacherCoursesView;
    private TeacherCoursesModel teacherCoursesModel;
    private String data;
    private Course[] transformCourses;

    public TeacherCoursesPresenter(TeacherCoursesView teacherCoursesView) {
        this.teacherCoursesView = teacherCoursesView;
    }

    public void getCourses() {
        Request request = new Request(Request.urlId.TEACHER_COURSES, Long.valueOf(3938849));
        AbstractAsyncTask abstractAsyncTask = new AbstractAsyncTask(this);
        abstractAsyncTask.execute(request);
    }

    private ArrayList<Course> getData(String json) {
        CourseDаo courseDаo = new CourseDаo();
        transformCourses = courseDаo.getAll(json);
        ArrayList<Course> list = new ArrayList();
        Collections.addAll(list, transformCourses);

        return list;
    }

    public void showCourses() {
        for (int i = 0; i < teacherCoursesModel.getCourses().size(); i++) {
            data = teacherCoursesModel.getCourses().get(i).getName() + "\n" + teacherCoursesModel.getCourses().get(i).getDescription();
            teacherCoursesView.showCourse(data);
        }
    }

    @Override
    public void updateModel(String json) {
        teacherCoursesModel = new TeacherCoursesModel(getData(json));
        showCourses();
    }


}

