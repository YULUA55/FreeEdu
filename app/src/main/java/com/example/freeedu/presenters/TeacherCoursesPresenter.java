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

    public void showNameOfCourses() {
        for (int i = 0; i < teacherCoursesModel.getCourses().size(); i++) {
            teacherCoursesView.showName(teacherCoursesModel.getCourses().get(i).getName());
        }

    }

    public void showDescriptions() {
        for (int i = 0; i < teacherCoursesModel.getCourses().size(); i++) {
            teacherCoursesView.showDescription(teacherCoursesModel.getCourses().get(i).getDescription());
        }

    }
}
