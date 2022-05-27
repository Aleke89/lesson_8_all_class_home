package com.example.lesson_8.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Store_Database extends SQLiteOpenHelper {
  public   static final String DATABASE_NAME = "quiz.db";
      static final int DATABASE_VERSION = 3;
    public  static final String DATABASE_TABLE = "users";
    public  static final String COLUMN_NAME = "name";
    public  static final String COLUMN_EMAIL = "email";
    public  static final String COLUMN_PASSWORD = "password";



    Context context;
    public Store_Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+DATABASE_TABLE +"("+
                COLUMN_NAME + " TEXT,"+
                COLUMN_EMAIL + " TEXT,"+
                COLUMN_PASSWORD + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
