package com.example.freeedu.views;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.freeedu.R;

public class MainActivity extends FragmentActivity implements TeacherView.onCourseButtonEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.teacher_fragment_container, TeacherView.newInstance(), "teacher_screen");
        transaction.addToBackStack("teacher_screen");
        transaction.commit();

    }

    @Override
    public void buttonWasClicked() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.teacher_fragment_container, TeacherCoursesView.newInstance(), "teacher_courses_screen");
        transaction.commit();


    }
}
