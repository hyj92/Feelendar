package com.hyuj.feelendar.domain;

import java.util.Date;

public class Diary {

    private Date date;
    private String memo;
    private Feel feel;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Feel getFeel() {
        return feel;
    }

    public void setFeel(Feel feel) {
        this.feel = feel;
    }
}
