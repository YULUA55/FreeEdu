package com.example.freeedu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.freeedu.dao.CourseDаo;
import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Teacher;


import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final CourseDаo courseDаo = new CourseDаo();
        final Teacher teacher = new Teacher("Uli", "Alenkova", "uli@mail.ru");
        Course[] transformCourses = courseDаo.getAll(
                "[{\"name\":\"Math_basic\",\"description\":\"For beginner\"},{\"name\":\"Programming_basic\",\"description\":\"For beginner\"},{\"name\":\"AI_basic\",\"description\":\"For beginner\"}]");

        ArrayList list = new ArrayList();
        Collections.addAll(list,transformCourses);
        teacher.setCourses(list);
        TextView name = (TextView)findViewById(R.id.id_name);
        TextView surname = (TextView)findViewById(R.id.id_surname);
        TextView email = (TextView)findViewById(R.id.id_email);
        name.setText(teacher.getName());
        surname.setText(teacher.getSurname());
        email.setText(teacher.getEmail());
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          TextView courses = (TextView) findViewById(R.id.id_courses);
                                          String course = new String();
                                          for(int i=0; i<teacher.getCourses().size();i++){
                                              course +=teacher.getCourses().get(i)+"\n";
                                          }
                                          courses.setText(course);

                                      }
                                  }
        );
    }
}