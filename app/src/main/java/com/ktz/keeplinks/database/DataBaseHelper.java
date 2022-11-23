package com.ktz.keeplinks.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;

    public static final String LINKS_TABLE = "link_table";
    public static final String KEY_ID = "id";
    public static final String KEY_LINK = "link";
    public static final String KEY_NOTE = "note";
    public static final String KEY_CATEGORY = "cateogry";
    public static final String KEY_SAVED_DATE = "saved_date";

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE " + LINKS_TABLE + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_LINK + " TEXT, " +
                KEY_NOTE + " TEXT, " +
                KEY_CATEGORY + " TEXT, " +
                KEY_SAVED_DATE + " TEXT);";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LINKS_TABLE);
        onCreate(db);
    }
}
