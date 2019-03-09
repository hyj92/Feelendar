package com.hyuj.feelendar.domain;

import java.util.Date;

public class Diary {

    private Date date;
    private String feelName;
    private String description;

    public Diary(Date date, String feelName, String description) {
        this.date = date;
        this.feelName = feelName;
        this.description = description;
    }

    public Diary(){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
