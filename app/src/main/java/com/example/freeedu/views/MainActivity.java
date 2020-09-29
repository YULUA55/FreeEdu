package com.example.freeedu.views;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.freeedu.R;

public class First_activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.teacher_fragment_container, TeacherView.newInstance(), "teacher_screen");
        transaction.addToBackStack("teacher_screen");
        Button button = (Button) findViewById(R.id.id_try_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("got");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.teacher_fragment_container,TeacherCoursesView.newInstance(),"teacher_screen");
                transaction.commit();

            }
        });
    }

    ;


}