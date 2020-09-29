package com.example.freeedu.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.freeedu.R;
import com.example.freeedu.presenters.TeacherMainPresenter;

public class TeacherActivity extends FragmentActivity implements BaseView {
    private TeacherMainPresenter presenter;
    private TextView name;
    private TextView surname;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new TeacherMainPresenter(this);
        name = (TextView) findViewById(R.id.id_name);
        surname = (TextView) findViewById(R.id.id_surname);
        email = (TextView) findViewById(R.id.id_email);
        showData();
    }

    @Override
    public void showData() {
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