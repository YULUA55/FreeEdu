package com.example.freeedu.presenters;


import com.example.freeedu.dao.StudentDao;
import com.example.freeedu.entities.Student;
import com.example.freeedu.model.ListOfStudentsModel;
import com.example.freeedu.views.ListOfStudentsView;

import java.util.ArrayList;
import java.util.Collections;

public class ListOfStudentsPresenter {

    private ListOfStudentsView studentsView;
    private ListOfStudentsModel model;
    private String data;

    public ListOfStudentsPresenter(ListOfStudentsView view) {
        this.studentsView = view;
        ArrayList<Student> students = getData();
        model = new ListOfStudentsModel(students);

    }

    private ArrayList<Student> getData() {
        StudentDao studentDao = new StudentDao();
        Student[] transformStudents = studentDao.getAll(
                "[{\"name\":\"Svetlana\",\"surname\":\"Imanul\",\"email\":\"svetik12@mail.ru\"},{\"name\":\"Galina\",\"surname\":\"Imfrhul\",\"email\":\"galya12@mail.ru\"}]");
        ArrayList list = new ArrayList();
        Collections.addAll(list, transformStudents);

        return list;
    }

    public void showListOfStudents() {
        for (int i = 0; i < model.getStudents().size(); i++) {
            data = model.getStudents().get(i).getName() + " " + model.getStudents().get(i).getSurname();
            studentsView.showStudent(data);
        }

    }

}
