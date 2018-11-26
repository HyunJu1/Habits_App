package com.example.administrator.marimo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class DataManager {

    Context context = null;
    public MarimoDBHelper marimoDBHelper;
    public HabitDBHelper habitDBHelper;
    public AllHabitDBHelper allHabitDBHelper;
    public StatusHabitDBHelper statusHabitDBHelper;

    public DataManager(Context aContext) {
        context = aContext;
        marimoDBHelper = new MarimoDBHelper(context);
        habitDBHelper = new HabitDBHelper(context);
        allHabitDBHelper = new AllHabitDBHelper(context);
        statusHabitDBHelper = new StatusHabitDBHelper(context);
    }

    // get marimo's name
    public String getMarimoName() {
        SQLiteDatabase marimoDB = marimoDBHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM marimo";
        Cursor cursor = marimoDB.rawQuery(selectQuery, null);
        String marimoName = null;

        while (cursor.moveToNext()) {
            marimoName = cursor.getString(1);
            Log.e("dbdbName",marimoName);
        }
        marimoDB.close();

        return marimoName;
    }

    //insert marimo
    public void enrollMarimo(String name){
        SQLiteDatabase marimoDB = marimoDBHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("marimo_name",name);
        cv.put("marimo_size",1);
        cv.put("status",1);
        marimoDB.insert("marimo",null,cv);

    }
    public void enrollHabit( int x, String strDate, String endDate){
        SQLiteDatabase habitDB = habitDBHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("habit_no",x);
        cv.put("start_date",strDate);
        cv.put("end_date",endDate);
        cv.put("push","더 똑똑해지는 중!");
        cv.put("category","공부");
        habitDB.insert("habit",null,cv);

    }
    public void enrollAllHabit( int x, String name){
        SQLiteDatabase all_habitDB = allHabitDBHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("all_no",x);
        cv.put("title",name);
        cv.put("content",name);
        cv.put("category","공부");
        all_habitDB.insert("all_habit",null,cv);

    }




}
