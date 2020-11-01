package com.example.freeedu.dao;

import com.example.freeedu.entities.Lesson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LessonSerializer implements JsonDeserializer<Lesson> {

    @Override
    public Lesson deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Lesson lesson = new Lesson();
        lesson.setDescription(jsonObject.get("description").getAsString());

        LocalDateTime dateTime = LocalDateTime.parse(jsonObject.get("date").getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        lesson.setData(dateTime);
        return lesson;
    }
}
