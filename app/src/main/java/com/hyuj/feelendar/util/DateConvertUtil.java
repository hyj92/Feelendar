package com.hyuj.feelendar.util;

import java.util.Calendar;

public class DateConvertUtil {

    /**
     * String을 Date객체로 바꿔주는 메소드 입니다.
     * @param {String} dateString
     * @return {Date}
     * */
    public static Calendar stringToDate(String dateString){
        if(dateString != null && dateString.length() >= 8){
            int year = Integer.parseInt(dateString.substring(0, 4));
            int month = Integer.parseInt(dateString.substring(4, 6));
            int day = Integer.parseInt(dateString.substring(6, 8));

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DATE, day);

            return calendar;
        }
        return null;
    }

    public static String dateToStringForView(Calendar calendar){
        return calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) +"/" + calendar.get(Calendar.DATE);
    }
}
