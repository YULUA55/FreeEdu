package com.example.freeedu.entities;

import androidx.annotation.Nullable;

public class Course {
    private long id;
    private String name;
    private String description;
    private long creatorId;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
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
}
