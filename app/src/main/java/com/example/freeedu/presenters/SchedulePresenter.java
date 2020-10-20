package com.example.freeedu.presenters;

import com.example.freeedu.dao.LessonDao;
import com.example.freeedu.entities.Lesson;
import com.example.freeedu.model.ScheduleModel;
import com.example.freeedu.views.ScheduleView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulePresenter {
    private ScheduleModel model;
    private ScheduleView view;

    public SchedulePresenter(ScheduleView view) {
        this.view = view;
        model = new ScheduleModel(getData(getScheduleForTeacher()));
    }

    public SchedulePresenter(ScheduleView view, String courseId) {
        this.view = view;
        model = new ScheduleModel(getData(getScheduleForCourse()));
    }


    private ArrayList<Lesson> getData(String json) {
        LessonDao lessonDao = new LessonDao();
        Lesson[] transformLessons = lessonDao.getAll(json);
        ArrayList list = new ArrayList();
        Collections.addAll(list, transformLessons);

        return list;
    }

    //request to the server to get common teacher's schedule
    private String getScheduleForTeacher(){
        String json = new String();
        json = "[{ \"description\":\"123\",\"date\":\"2021-07-09T09:11:06\"},{ \"description\":\"123\",\"date\":\"2022-07-09T09:11:06\"}]";
        return json;
    }

    //request to the server to get schedule of specific course
    private String getScheduleForCourse(){
        String json = new String();
        json = "[{ \"description\":\"123\",\"date\":\"2021-07-09T09:11:06\"}]";
        return json ;
    }

    public void showLessons() {
        List<Lesson> lessons = model.getLessons().stream().filter((lesson) -> (lesson.getDate().compareTo(LocalDateTime.now())>0)).collect(Collectors.toList());
        for (int i = 0; i < lessons.size(); i++) {
            String data = lessons.get(i).getDate().toString();
            view.showLesson(data);
        }

    }

}
