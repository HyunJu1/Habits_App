package com.example.administrator.marimo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MarimoDBHelper extends SQLiteOpenHelper {
    public MarimoDBHelper(Context context) {
        super(context, "marimo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table marimo(" +
                " marimo_no Integer primary key," +
                " marimo_name TEXT not null," +
                " marimo_size Integer not null," +
                " status Integer not null" +
                ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
