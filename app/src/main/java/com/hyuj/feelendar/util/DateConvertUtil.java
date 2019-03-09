package com.hyuj.feelendar.util;

import java.util.Date;

public class DateConvertUtil {

    /**
     * String을 Date객체로 바꿔주는 메소드 입니다.
     * @param {String} dateString
     * @return {Date}
     * */
    public static Date stringToDate(String dateString){
        if(dateString != null && dateString.length() >= 8){
            int year = Integer.parseInt(dateString.substring(0, 4));
            int month = Integer.parseInt(dateString.substring(4, 6));
            int day = Integer.parseInt(dateString.substring(6, 8));

            return new Date(year, month, day);
        }
        return null;
    }
}
