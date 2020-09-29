package com.example.freeedu.views;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.freeedu.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.teacher_fragment_container, TeacherView.newInstance(), "teacher_screen");
        transaction.addToBackStack("teacher_screen");
        transaction.commit();
        Button button = (Button) findViewById(R.id.id_try_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.teacher_fragment_container, TeacherCoursesView.newInstance(), "teacher_courses_screen");
                transaction.commit();

            }
        });
    }

    ;


}