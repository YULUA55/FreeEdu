package com.example.freeedu.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.freeedu.R;
import com.example.freeedu.presenters.TeacherCoursesPresenter;

public class TeacherCoursesView extends Fragment implements BaseView {
    TeacherCoursesPresenter presenter;
    TableLayout box;


    public static TeacherCoursesView newInstance() {
        return new TeacherCoursesView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coureses_fragment, container, false);
        presenter = new TeacherCoursesPresenter(this);
        box = view.findViewById(R.id.courses_box);
        showDataAtFirst();
        return view;
    }

    public void showDataAtFirst() {
        presenter.showCourses();
    }


    public void showCourse(String data) {
        TableRow tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        tableRow.addView(generateImage());
        tableRow.addView(generateDescription(data));
        box.addView(tableRow);

    }

    private TextView generateDescription(String data) {
        TextView course = new TextView(getContext());
        course.setText(data);
        course.setTextSize(25);
        return course;
    }

    private ImageView generateImage() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.course);
        TableRow.LayoutParams imageViewLayoutParams = new TableRow.LayoutParams(300, 300);
        imageView.setLayoutParams(imageViewLayoutParams);
        return imageView;
    }


}