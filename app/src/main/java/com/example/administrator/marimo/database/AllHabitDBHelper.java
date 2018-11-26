package com.example.administrator.marimo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AllHabitDBHelper extends SQLiteOpenHelper {
    public AllHabitDBHelper(Context context) {
        super(context, "all_hablit.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table all_habit(" +
                "  all_no Integer primary key," +
                "  title TEXT not null," +
                "  content TEXT not null," +
                "  category TEXT not null"+
                ");");



        db.execSQL("insert into all_habit values (30, '토익리스닝', 'content1', '공부');");
        db.execSQL("insert into all_habit values (31, '10분 일찍 일어나기', 'content2', '생활패턴');");
        db.execSQL("insert into all_habit values (32, '30분 운동하기', 'content3', '건강');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
