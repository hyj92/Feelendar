package com.hyuj.feelendar.helper;

import com.hyuj.feelendar.domain.Diary;

import java.util.Date;
import java.util.List;

/**
 * Database 접근을 위한 Helper Interface입니다.
 * 새로운 Database를 사용하면, 해당 Interface를 구현해 Helper 클래스를 만들어야 합니다.
 *
 * @author hyj12082
 * */
public interface DatabaseAccessHelper {

    List<Diary> getDiaryList(Date startDate, Date endDate);

}
