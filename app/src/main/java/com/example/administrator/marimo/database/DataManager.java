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




}
