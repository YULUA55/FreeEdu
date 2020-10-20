package com.example.freeedu.views;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.freeedu.R;

public class MainActivity extends FragmentActivity {

    public enum ScreenId {
        TEACHER_MAIN("teacher_screen"),
        TEACHER_COURSES("teacher's courses_screen"),
        LIST_OF_STUDENTS("list_of_student_screen"),
        COURSE_SCHEDULE("course_schedule"),
        TEACHER_SCHEDULE("teacher_schedule");

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
            case TEACHER_MAIN:
                transaction.replace(R.id.teacher_fragment_container, TeacherView.newInstance(), screenId.getTag());
                break;
            case TEACHER_COURSES:
                transaction.replace(R.id.teacher_fragment_container, TeacherCoursesView.newInstance(), screenId.getTag());
                break;
            case LIST_OF_STUDENTS:
                transaction.replace(R.id.teacher_fragment_container, ListOfStudentsView.newInstance(),screenId.getTag());
                break;
            case COURSE_SCHEDULE:
                transaction.replace(R.id.teacher_fragment_container, new ScheduleView(true),screenId.getTag());
                break;
            case TEACHER_SCHEDULE:
                transaction.replace(R.id.teacher_fragment_container, new ScheduleView(false),screenId.getTag());
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
