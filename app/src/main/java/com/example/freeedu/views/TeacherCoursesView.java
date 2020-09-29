package com.example.freeedu.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.freeedu.R;
import com.example.freeedu.presenters.TeacherCoursesPresenter;

public class TeacherCoursesView extends Fragment implements BaseView {
    TeacherCoursesPresenter presenter;
    TextView name;
    TextView description;


    public static TeacherCoursesView newInstance() {

        return new TeacherCoursesView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coureses_fragment, container, false);
        presenter = new TeacherCoursesPresenter(this);
        name = view.findViewById(R.id.id_course_name);
        description = view.findViewById(R.id.id_description);
        showDataAtFirst();
        return view;
    }

    public void showDataAtFirst() {
        presenter.showNameOfCourses();
        presenter.showDescriptions();
    }

    public void showName(String receivedName) {
        name.setText(name.getText() + "\n" + receivedName);

    }

    public void showDescription(String receivedDescription) {
        description.setText(description.getText() + "\n" + receivedDescription);
    }


}