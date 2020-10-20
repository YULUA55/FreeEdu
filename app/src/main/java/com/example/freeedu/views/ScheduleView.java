package com.example.freeedu.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.freeedu.R;
import com.example.freeedu.presenters.SchedulePresenter;

public class ScheduleView extends Fragment implements BaseView {
    boolean courses;
    SchedulePresenter presenter;
    TableLayout box;

    public ScheduleView(boolean courses) {
        this.courses = courses;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schedule_fragment, container, false);
        if (courses) {
            presenter = new SchedulePresenter(this, "courseId");
        } else presenter = new SchedulePresenter(this);
        box = view.findViewById(R.id.schedule_box);
        showDataAtFirst();
        return view;
    }

    public void showDataAtFirst() {
        presenter.showLessons();
    }


    public void showLesson(String data) {
        TableRow tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        tableRow.addView(generateDescription(data));
        box.addView(tableRow);

    }


    private TextView generateDescription(String data) {
        TextView lesson = new TextView(getContext());
        System.out.println(lesson);
        lesson.setText(data);
        lesson.setTextSize(25);
        return lesson;
    }

}