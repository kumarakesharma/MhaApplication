package com.mha.learningConcept.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mha.learningConcept.util.Utility;

import kotlin.jvm.internal.PropertyReference0Impl;

public class DbAdapter {
    // DB & TBALE NAMES, VERSION
    private final String DB_NAME = "mha";
    private final String TABLE_NAME = "userInfo";
    private final int DB_VERSION = 1;

    // TABLE COLUMN NAME
    private final String SER_NO = "sNo"; // AUDTOINCREMENT PRIMARY KEY
    private final String FIRST_NAME = "fName"; // TEXT
    private final String LAST_NAME = "lName"; // TEXT
    private final String MOBILE_NO = "mobNo"; // TEXT.

    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    // "CREATE TABLE TABLE_NAME (SER_NO INTEGER PRIMARY KEY AUTOINCREMENT, FRIST_NAME TEXT, LAST_NAME TEXT, MOBILE_NO TEXT)";
    private String stringQuery = "CREATE TABLE "+TABLE_NAME+" ("+SER_NO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FIRST_NAME+" text, "+LAST_NAME+" text, "+
            MOBILE_NO+" text"+")";


    public DbAdapter(Context context){
        dbHelper = new DbHelper(context);
    }

    public DbAdapter openDatabase(){
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }


    public void closeDatabase(){
        sqLiteDatabase.close();
    }

    public void insertData(Context context, String firstName, String lastName, String mobileNumber){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, firstName);
        contentValues.put(LAST_NAME, lastName);
        contentValues.put(MOBILE_NO, mobileNumber);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (id == 0){
            Utility.showShortToast(context, "Insertion failed...");
        }else {
            Utility.showShortToast(context, "Successfully inserted...");
        }

    }

    public Cursor getData(){
        String[] COLUMNS = {SER_NO, FIRST_NAME, LAST_NAME, MOBILE_NO};
        return sqLiteDatabase.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
    }


    class DbHelper extends SQLiteOpenHelper{

        public DbHelper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(stringQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }







}
