package com.hyuj.feelendar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import com.hyuj.feelendar.domain.Diary;
import com.hyuj.feelendar.domain.Feel;
import com.hyuj.feelendar.util.DateConvertUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;


/**
 * SQLite 접근을 위한 SQLiteOpenHelper 클래스를 상속받은 Helper 클래스입니다.
 * Activity Context 를 넘겨야 하기 때문에 (SQLiteOpenHelper) 싱글톤 객체로 사용되지 않습니다.
 *
 * @author hyj12082
 * */
public class SQLiteAccessHelper extends SQLiteOpenHelper implements DatabaseAccessHelper {

    /**
     * Table, Column 명 상수를 가지는 static 클래스 입니다.
     * */
    public static class ColumnConstant implements BaseColumns {
        public static final String TB_DIARY = "TB_DIARY";
        public static final String TB_FEEL = "TB_FEEL_META_DATA";
        public static final String COLUMN_DIARY_DATE = "DIARY_DATE";
        public static final String COLUMN_FEEL = "FEEL_CODE";
        public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
        public static final String COLUMN_RESOURCE_ID = "RESOURCE_ID";
        public static final String COLUMN_SCORE = "SCORE";
    }

    private static final String SQL_CREATE_DIARY_TABLE = "CREATE TABLE " + ColumnConstant.TB_DIARY +
            "(DIARY_DATE TEXT PRIMARY KEY, " +
            ColumnConstant.COLUMN_FEEL + " TEXT," +
            "DESCRIPTION TEXT)";
    private static final String SQL_CREATE_FEEL_TABLE = "CREATE TABLE " + ColumnConstant.TB_FEEL +
            "(FEEL_CODE TEXT PRIMARY KEY," +
            "RESOURCE_ID INTEGER," +
            "SCORE INTEGER);";
    private static final String SQL_DELETE_DIARY_TABLE = "DROP TABLE IF EXISTS " + ColumnConstant.TB_FEEL;
    private static final String SQL_DELETE_FEEL_TABLE = "DROP TABLE IF EXISTS " + ColumnConstant.TB_DIARY;

    private static final String[] COLUMNS_DIARY_SELECT = {
            ColumnConstant.COLUMN_DIARY_DATE,
            ColumnConstant.COLUMN_FEEL,
            ColumnConstant.COLUMN_DESCRIPTION
    };

    private static final String[] COLUMNS_FEEL_SELECT = {
            ColumnConstant.COLUMN_SCORE,
            ColumnConstant.COLUMN_FEEL,
            ColumnConstant.COLUMN_RESOURCE_ID
    };

    private static final String WHERE_DIARY_SELECT = ColumnConstant.COLUMN_DIARY_DATE + " BETWEEN ? AND ?";

    private static final int DEFAULT_VERSION = 1;
    private static final String DEFAULT_DB_NAME = "Feelendar.db";

    public SQLiteAccessHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                              int version, @Nullable DatabaseErrorHandler errorHandler) {
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
        db.execSQL(SQL_CREATE_DIARY_TABLE);
        db.execSQL(SQL_CREATE_FEEL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_DIARY_TABLE);
        db.execSQL(SQL_DELETE_FEEL_TABLE);
        onCreate(db);
    }

    /**
     * SQLite에서 startDate ~ endDate 기간에 해당하는 Diary를 가져옵니다.
     *
     * @param start
     * @param end
     * @return {List<Diary>}
     * */
    @Override
    public List<Diary> selectDiaryList(Calendar start, Calendar end) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Diary> diaryList = new ArrayList<>();

        Cursor cursor = db.query(
                ColumnConstant.TB_DIARY,          // The table to query
                COLUMNS_DIARY_SELECT,             // The array of columns to return (pass null to get all)
                WHERE_DIARY_SELECT,               // The columns for the WHERE clause
                new String[]{start.toString(), end.toString()},             // The values for the WHERE clause
                null,                   // don't group the rows
                null,                    // don't filter by row groups
                null                    // The sort order
        );

        while(cursor.moveToNext()) {
            String dateString = cursor.getString(cursor.getColumnIndexOrThrow(ColumnConstant.COLUMN_DIARY_DATE));
            String feelName = cursor.getString(cursor.getColumnIndexOrThrow(ColumnConstant.COLUMN_FEEL));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(ColumnConstant.COLUMN_DESCRIPTION));

            diaryList.add(new Diary(DateConvertUtil.stringToDate(dateString), feelName, description));
        }
        cursor.close();

        return diaryList;
    }

    @Override
    public List<Feel> selectFeelList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Feel> feelList = new ArrayList<>();

        Cursor cursor = db.query(
                ColumnConstant.TB_FEEL,
                COLUMNS_FEEL_SELECT,
                null, null, null, null, null
        );

        while(cursor.moveToNext()) {
            String feelName = cursor.getString(cursor.getColumnIndexOrThrow(ColumnConstant.COLUMN_FEEL));
            int resourceId = cursor.getInt(cursor.getColumnIndexOrThrow(ColumnConstant.COLUMN_RESOURCE_ID));
            int score = cursor.getInt(cursor.getColumnIndexOrThrow(ColumnConstant.COLUMN_SCORE));

            feelList.add(new Feel(feelName, resourceId, score));
        }
        cursor.close();

        return feelList;
    }


    @Override
    public void insertDiary(Diary diary) {
        // writable db를 가져옵니다. 내부적으로 synchronized를 사용고 있으며, thread-safe를 위해 그때 그때 해당 함수를 호출하도록 합니다.
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ColumnConstant.COLUMN_DIARY_DATE, diary.getDate().toString().replaceAll("\\D", ""));
        values.put(ColumnConstant.COLUMN_FEEL,diary.getFeelName());
        values.put(ColumnConstant.COLUMN_DESCRIPTION, diary.getDescription());

        long newRowId = db.insert(ColumnConstant.TB_DIARY, null, values);
        if(newRowId < 0) new Exception("FAIL TO INSERT DIARY " + diary.getDate() + "," + diary.getFeelName());
    }

    @Override
    public void insertFeel(Feel feel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ColumnConstant.COLUMN_FEEL, feel.getName());
        values.put(ColumnConstant.COLUMN_RESOURCE_ID, feel.getResourceId());
        values.put(ColumnConstant.COLUMN_SCORE, feel.getScore());

        long newRowId = db.insert(ColumnConstant.TB_FEEL, null, values);
        if(newRowId < 0) new Exception("FAIL TO INSERT FEEL " + feel.getName());
    }


}
