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
import com.example.freeedu.presenters.ListOfStudentsPresenter;

public class ListOfStudentsView extends Fragment implements BaseView {
    ListOfStudentsPresenter presenter;
    TableLayout box;


    public static ListOfStudentsView newInstance() {
        return new ListOfStudentsView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_of_students_fragment, container, false);
        presenter = new ListOfStudentsPresenter(this);
        box = view.findViewById(R.id.students_box);
        showDataAtFirst();
        return view;
    }

    public void showDataAtFirst() {
        presenter.requestFromModel();
    }


    public void showStudent(String data) {
        TableRow tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
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