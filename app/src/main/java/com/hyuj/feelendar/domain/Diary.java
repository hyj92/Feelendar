package com.hyuj.feelendar.domain;

import java.util.Calendar;

public class Diary {

    private Calendar date;
    private String feelName;
    private String description;

    public Diary(Calendar date, String feelName, String description) {
        this.date = date;
        this.feelName = feelName;
        this.description = description;
    }

    public Diary(){}

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeelName() {
        return feelName;
    }

    public void setFeelName(String feelName) {
        this.feelName = feelName;
    }
}
