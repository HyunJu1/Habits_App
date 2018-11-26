package com.example.administrator.marimo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class HabitDBHelper extends SQLiteOpenHelper {
    public HabitDBHelper(Context context) {
        super(context, "habit.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table habit(" +
                " habit_no Integer primary key," +
                " start_date TEXT not null," +
                " end_date TEXT not null," +
                " push TEXT," +
                " category TEXT,"+
                " history Integer default 0," +    //default값 (0 진행중, 1 완료)
                " constraint fk_habit foreign key (habit_no) references all_habit(all_no)" +
                " );");



        // sample data
        db.execSQL("insert into habit values (30, '2018-11-25', '2019-01-04', '공부하셨나요?', '공부', 0);");
        db.execSQL("insert into habit values (31, '2018-11-26', '2019-01-10', '10분 일찍 시작했나요?', '생활패턴', 0);");
        db.execSQL("insert into habit values (32, '2018-11-28', '2019-01-11', '운동하셨나요?', '건강', 0);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
