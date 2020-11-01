package com.example.freeedu.presenters;


import com.example.freeedu.dao.StudentDao;
import com.example.freeedu.entities.Student;
import com.example.freeedu.model.ListOfStudentsModel;
import com.example.freeedu.views.ListOfStudentsView;

import java.util.List;

public class ListOfStudentsPresenter implements BasePresenter<Student> {

    private ListOfStudentsView studentsView;
    private ListOfStudentsModel studentsModel;
    private StudentDao studentDao;

    public ListOfStudentsPresenter(ListOfStudentsView view) {
        this.studentsView = view;
        this.studentDao = new StudentDao(this);
    }

    @Override
    public void requestFromModel() {
        studentDao.sendRequest();
    }

    @Override
    public void updateModel(List<Student> data) {
        studentsModel = new ListOfStudentsModel(data);
        updateView();
    }

    @Override
    public void updateModel(Student data) {

    }

    @Override
    public void updateView() {
        String data;
        for (int i = 0; i < studentsModel.getStudents().size(); i++) {
            data = studentsModel.getStudents().get(i).getName() + " " + studentsModel.getStudents().get(i).getSurname();
            studentsView.showStudent(data);
        }
    }

    @Override
    public void error(String errorMessage) {
        System.out.println("Сообщить на вьюшке об ошибке");
    }

}
