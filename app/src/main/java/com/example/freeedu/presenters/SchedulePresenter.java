package com.example.freeedu.presenters;

import com.example.freeedu.dao.LessonDao;
import com.example.freeedu.entities.Lesson;
import com.example.freeedu.model.ScheduleModel;
import com.example.freeedu.views.MainActivity;
import com.example.freeedu.views.ScheduleView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulePresenter implements BasePresenter<Lesson> {

    public enum SenderEntity {
        TEACHER,
        STUDENT,
        COURSE
    }

    private ScheduleModel model;
    private ScheduleView view;
    private LessonDao lessonDao;

    public SchedulePresenter(ScheduleView view) {
        this.view = view;
        this.lessonDao = new LessonDao(this);
    }

    @Override
    public void requestFromModel() {

    }

    public void requestFromModel(SenderEntity senderEntity) {
        switch (senderEntity) {
            case COURSE:
                lessonDao.sendRequest();
                break;
            case STUDENT:
                lessonDao.sendRequest();
                break;
            case TEACHER:
                lessonDao.sendRequest();
                break;

        }
    }

    @Override
    public void updateModel(Lesson data) {

    }

    @Override
    public void updateModel(List<Lesson> data) {
        this.model = new ScheduleModel(data);
    }


    @Override
    public void updateView() {
        List<Lesson> lessons = model.getLessons().stream().filter((lesson) -> (lesson.getDate().compareTo(LocalDateTime.now()) > 0)).collect(Collectors.toList());
        for (int i = 0; i < lessons.size(); i++) {
            String data = lessons.get(i).getDate().toString();
            view.showLesson(data);
        }

    }

    @Override
    public void error(String errorMessage) {
        System.out.println("Error Message for View");
    }
}
