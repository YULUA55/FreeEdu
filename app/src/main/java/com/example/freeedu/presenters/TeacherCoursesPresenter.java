package com.example.freeedu.presenters;

import com.example.freeedu.dao.CourseDаo;
import com.example.freeedu.entities.Course;
import com.example.freeedu.model.TeacherCoursesModel;
import com.example.freeedu.views.TeacherCoursesView;

import java.util.ArrayList;
import java.util.Collections;

public class TeacherCoursesPresenter {

    private TeacherCoursesView teacherCoursesView;
    private TeacherCoursesModel teacherCoursesModel;
    private String data;

    public TeacherCoursesPresenter(TeacherCoursesView teacherCoursesView) {
        this.teacherCoursesView = teacherCoursesView;
        ArrayList<Course> courses = getData();
        teacherCoursesModel = new TeacherCoursesModel(courses);
    }

    private ArrayList<Course> getData() {
        CourseDаo courseDаo = new CourseDаo();
        Course[] transformCourses = courseDаo.getAll(
                "[{\"name\":\"Math_basic\",\"description\":\"For beginner\"},{\"name\":\"Programming_basic\",\"description\":\"For beginner\"},{\"name\":\"AI_basic\",\"description\":\"For beginner\"}]");
        ArrayList list = new ArrayList();
        Collections.addAll(list, transformCourses);

        return list;
    }

    public void showCourses() {
        for (int i = 0; i < teacherCoursesModel.getCourses().size(); i++) {
            data = teacherCoursesModel.getCourses().get(i).getName() + "\n" + teacherCoursesModel.getCourses().get(i).getDescription();
            teacherCoursesView.showCourse(data);
        }

    }

}
