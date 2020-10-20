package com.example.freeedu.entities;


import androidx.annotation.Nullable;

import java.time.LocalDateTime;

public class Lesson {
    private long id;
    private String description;
    private LocalDateTime date;

    public Lesson(){};

    public Lesson(String description, LocalDateTime date) {
        this.description = description;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setData(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Lesson guest = (Lesson) obj;
        return (((description.equals(guest.getDescription())) && date.equals(guest.getDate()))
        );
    }
}
