package com.example.freeedu.presenters;

import com.example.freeedu.dao.CourseDаo;
import com.example.freeedu.entities.Course;
import com.example.freeedu.model.TeacherCoursesModel;
import com.example.freeedu.views.TeacherCoursesView;

import java.util.List;

public class TeacherCoursesPresenter implements BasePresenter<Course> {

    private TeacherCoursesView teacherCoursesView;
    private TeacherCoursesModel teacherCoursesModel;
    private CourseDаo courseDаo;

    public TeacherCoursesPresenter(TeacherCoursesView teacherCoursesView) {
        this.teacherCoursesView = teacherCoursesView;
        courseDаo = new CourseDаo(this);
    }

    @Override
    public void requestFromModel() {
        courseDаo.sendRequest();
    }

    @Override
    public void updateModel(List<Course> data) {
        teacherCoursesModel = new TeacherCoursesModel(data);
        updateView();
    }

    @Override
    public void updateModel(Course data) {

    }

    @Override
    public void updateView() {
        String data;
        for (int i = 0; i < teacherCoursesModel.getCourses().size(); i++) {
            data = teacherCoursesModel.getCourses().get(i).getName() + "\n" + teacherCoursesModel.getCourses().get(i).getDescription();
            teacherCoursesView.showCourse(data);
        }
    }

    @Override
    public void error(String errorMessage) {

        System.out.println("Сообщить на вьюшке об ошибке");
    }

}

