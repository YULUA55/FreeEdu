package com.example.freeedu.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Teacher {
    private long id;
    private String name;
    private String surname;
    private String email;

    public Teacher(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Teacher guest = (Teacher) obj;
        return ((name.equals(guest.getName())) && (surname.equals(guest.getSurname()))
        );
    }

}
