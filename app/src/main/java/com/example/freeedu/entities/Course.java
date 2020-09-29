package com.example.freeedu.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Course {
    private long id;
    private String name;
    private String description;


    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Course guest = (Course) obj;
        return ((name.equals( guest.getName())) && (description.equals( guest.getDescription()))
        );
    }

    @NonNull
    @Override
    public String toString() {
        return "\n Name:" + this.name + "\n Description: " + this.description;
    }
}
