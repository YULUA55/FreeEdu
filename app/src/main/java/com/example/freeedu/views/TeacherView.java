package com.example.freeedu.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.freeedu.R;
import com.example.freeedu.presenters.TeacherMainPresenter;

public class TeacherView extends Fragment implements BaseView {

    private TeacherMainPresenter presenter;
    private TextView name;
    private TextView surname;
    private TextView email;
    private Button button;

    public static TeacherView newInstance() {
        return new TeacherView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_fragment, container, false);
        presenter = new TeacherMainPresenter(this);
        name = view.findViewById(R.id.id_name);
        surname = view.findViewById(R.id.id_surname);
        email = view.findViewById(R.id.id_email);

        Button button = view.findViewById(R.id.id_course_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).navigateToScreen(MainActivity.ScreenId.TEACHER_COURSES);
            }
        });
        showDataAtFirst();
        return view;
    }


    @Override
    public void showDataAtFirst() {
        presenter.showName();
        presenter.showEmail();
        presenter.showSurname();
    }

    public void showName(String receivedName) {
        name.setText(receivedName);
    }

    public void showSurname(String receivedSurname) {
        surname.setText(receivedSurname);
    }

    public void showEmail(String receivedEmail) {
        email.setText(receivedEmail);
    }
}