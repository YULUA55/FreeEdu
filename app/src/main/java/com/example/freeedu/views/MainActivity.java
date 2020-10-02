package com.example.freeedu.views;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.freeedu.R;

public class MainActivity extends FragmentActivity {

    public enum ScreenId {
        LOGIN_SCREEN("login_screen"),
        TEACHER_MAIN("teacher_screen"),
        TEACHER_COURSES("student_screen");

        private String mTag;

        ScreenId(String tag) {
            mTag = tag;
        }

        public String getTag() {
            return mTag;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.teacher_fragment_container, TeacherView.newInstance(), "teacher_screen");
        transaction.addToBackStack("teacher_screen");
        transaction.commit();
    }

    public boolean navigateToScreen(ScreenId screenId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (screenId) {
            case LOGIN_SCREEN:
                break;
            case TEACHER_MAIN:
                transaction.add(R.id.teacher_fragment_container, TeacherView.newInstance(), screenId.getTag());
                break;
            case TEACHER_COURSES:
                transaction.add(R.id.teacher_fragment_container, TeacherCoursesView.newInstance(), screenId.getTag());
                break;
        }

        transaction.addToBackStack(screenId.getTag());
        transaction.commit();

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // TODO implement
//        getSupportFragmentManager().popBackStackImmediate()
    }
}
