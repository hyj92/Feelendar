package com.hyuj.feelendar.component;

import com.hyuj.feelendar.domain.Diary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 통계 데이터 집계를 위한 컴포넌트 클래스입니다.
 * 집계를 위한 기능의 역할만 수행하므로 싱글톤으로 구현했습니다.
 * 해당 컴포넌트를 사용하기 위해서는 getInstance() 메소드를 사용해야 합니다.
 *
 * @author hyj12082
 * */
public class StatisticsComponent {

    // static class를 사용하여 class load 시점에서 StatisticsComponent가 initialize 됩니다.(싱글톤 패턴)
    private static class StatisticsHodler {
        public static final StatisticsComponent statisticsComponent = new StatisticsComponent();
    }

    /**
     * 컴포넌트 인스턴스를 가져오는 메소드입니다.(싱글톤 패턴)
     * @return StatisticsComponent
     * */
    public StatisticsComponent getInstance(){
        return StatisticsHodler.statisticsComponent;
    }

    // 바깥에서 생성을 방지하기위해 생성자를 private으로 지정했습니다.
    private StatisticsComponent(){}

    /**
     * 시작 날짜부터 끝 날짜까지의 diary를 가져오는 메소드입니다.
     * @param startDate
     * @param endDate
     * @return {List<Diary>} 날짜 내림차순으로 반환됩니다.
     * */
    public List<Diary> getDiaryListInRange(Date startDate, Date endDate) {
        List<Diary> diaryList = new ArrayList<>();


        return diaryList;
    }
}
