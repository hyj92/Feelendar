package com.hyuj.feelendar.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.hyuj.feelendar.domain.Diary;

import java.util.Date;
import java.util.List;

/**
 * SQLite 접근을 위한 SQLiteOpenHelper 클래스를 상속받은 Helper 클래스입니다.
 * Activity Context 를 넘겨야 하기 때문에 (SQLiteOpenHelper) 싱글톤 객체로 사용되지 않습니다.
 *
 * @author hyj12082
 * */
public class SQLiteAccessHelper extends SQLiteOpenHelper implements DatabaseAccessHelper {

    private static final int DEFAULT_VERSION = 1;
    private static final String DEFAULT_DB_NAME = "db_feelendar";

    public SQLiteAccessHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    /**
     * 간단하게 사용할 수 있는 생성자 입니다.
     * @param context
     * */
    public SQLiteAccessHelper(Context context){
        super(context, DEFAULT_DB_NAME, null, DEFAULT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // table 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // version update
    }

    /**
     * SQLite에서 startDate ~ endDate 기간에 해당하는 Diary를 가져옵니다.
     *
     * @param startDate
     * @param endDate
     * @return {List<Diary>}
     * */
    @Override
    public List<Diary> getDiaryList(Date startDate, Date endDate) {
        return null;
    }
}
