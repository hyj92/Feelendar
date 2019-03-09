package com.hyuj.feelendar.domain;

public class Feel {

    private String name;
    private int resourceId;
    private int score;

    public Feel(String name, int resourceId, int score) {
        this.name = name;
        this.resourceId = resourceId;
        this.score = score;
    }

    public Feel(String name) {
        this.name = name;
    }

    public Feel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
