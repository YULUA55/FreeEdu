package com.example.freeedu.presenters;

import androidx.fragment.app.FragmentTransaction;

import com.example.freeedu.dao.AbstractDao;
import com.example.freeedu.dao.TeacherDao;
import com.example.freeedu.entities.Teacher;
import com.example.freeedu.model.AppModel;
import com.example.freeedu.model.TeacherMainModel;
import com.example.freeedu.views.TeacherView;

import java.util.List;

public class TeacherMainPresenter implements BasePresenter<Teacher> {

    private TeacherView teacherMainView;
    private TeacherMainModel teacherMainModel;
    private TeacherDao teacherDao;

    public TeacherMainPresenter(TeacherView teacherMainView) {
        this.teacherMainView = teacherMainView;
        this.teacherDao = new TeacherDao(this);
    }

    public void requestFromModel(){
        teacherDao.sendRequest();
    }

    @Override
    public void updateModel(List<Teacher> data) {

    }

    @Override
    public void updateModel(Teacher data) {
        teacherMainModel = new TeacherMainModel(data);
        updateView();
    }

    @Override
    public void updateView() {
        teacherMainView.showName(teacherMainModel.getTeacher().getName());
        teacherMainView.showSurname(teacherMainModel.getTeacher().getSurname());
        teacherMainView.showEmail(teacherMainModel.getTeacher().getEmail());
    }

    @Override
    public void error(String errorMessage) {

    }

}
