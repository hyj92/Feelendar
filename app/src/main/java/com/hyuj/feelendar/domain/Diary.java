package com.hyuj.feelendar.domain;

import java.util.Calendar;

public class Diary {

    private Calendar calendar;
    private String feelName;
    private String description;

    public Diary(Calendar calendar, String feelName, String description) {
        this.calendar = calendar;
        this.feelName = feelName;
        this.description = description;
    }

    public Diary(){}

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
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
