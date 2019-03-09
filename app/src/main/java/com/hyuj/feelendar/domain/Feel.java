package com.hyuj.feelendar.domain;

public class Feel {

    private String name;
    private String resourceId;
    private int score;

    public Feel(String name, String resourceId, int score) {
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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
