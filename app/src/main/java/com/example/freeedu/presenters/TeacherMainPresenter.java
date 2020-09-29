package com.example.freeedu.presenters;

import androidx.fragment.app.FragmentTransaction;

import com.example.freeedu.dao.TeacherDao;
import com.example.freeedu.entities.Teacher;
import com.example.freeedu.model.AppModel;
import com.example.freeedu.model.TeacherMainModel;
import com.example.freeedu.views.TeacherView;

public class TeacherMainPresenter {

    private TeacherView teacherMainView;
    private TeacherMainModel teacherMainModel;

    public TeacherMainPresenter(TeacherView teacherMainView) {
        this.teacherMainView = teacherMainView;
        this.teacherMainModel = new TeacherMainModel(getData());
    }


    public void showName() {
        teacherMainView.showName(teacherMainModel.getTeacher().getName());
    }

    public void showSurname() {
        teacherMainView.showSurname(teacherMainModel.getTeacher().getSurname());
    }

    public void showEmail() {
        teacherMainView.showEmail(teacherMainModel.getTeacher().getEmail());
    }


    private Teacher getData() {
        TeacherDao teacherDao = new TeacherDao();
        Teacher teacher = teacherDao.getEntity("{ \"name\":" + AppModel.getInstance().getUserId() + ",\"surname\":\"Alenkova\",\"email\":\"uli@mail.ru\" }");
        return teacher;
    }
}
