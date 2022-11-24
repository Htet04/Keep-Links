package com.ktz.keeplinks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;

    public static final String LINKS_TABLE = "link_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LINK = "link";
    public static final String CATEGORY = "cateogry";
    public static final String NOTE = "note";
    public static final String SAVED_DATE = "saved_date";

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE " + LINKS_TABLE + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME+" TEXT,"+
                LINK + " TEXT, " +
                CATEGORY + " TEXT, " +
                NOTE + " TEXT, " +
                SAVED_DATE + " TEXT);";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LINKS_TABLE);
        onCreate(db);
    }

    public long addLink(String name,String link, String category, String note, String saved_date) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(LINK, link);
        values.put(CATEGORY, category);
        values.put(NOTE, note);
        values.put(SAVED_DATE, saved_date);
        return db.insert(LINKS_TABLE, null, values);
    }

    public void updateLink(long id,String name, String link, String category, String note, String saved_date) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(LINK, link);
        values.put(CATEGORY, category);
        values.put(NOTE, note);
        values.put(SAVED_DATE, saved_date);
        db.update(LINKS_TABLE, values, ID + "=" + id, null);
    }

    /**
     * @throws NullPointerException*/
    public int size(){
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(id) FROM "+LINKS_TABLE,null);
        if (cursor!=null) {
            cursor.moveToFirst();
            int result = cursor.getInt(1);
            cursor.close();
            return result;
        }
        return 0;
    }

    public String getName(long id){
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        if (cursor!=null) {
            cursor.moveToFirst();
            String result = cursor.getString(1);
            cursor.close();
            return result;
        }
        return "";
    }

    public String getLink(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        if (cursor!=null) {
            cursor.moveToFirst();
            String result = cursor.getString(2);
            cursor.close();
            return result;
        }
        return "";
    }
    public String getCategory(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        if (cursor!=null) {
            cursor.moveToFirst();
            String result = cursor.getString(3);
            cursor.close();
            return result;
        }
        return "";
    }
    public String getNote(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        if (cursor!=null) {
            cursor.moveToFirst();
            String result = cursor.getString(4);
            cursor.close();
            return result;
        }
        return "";
    }
    public String getSavedDate(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        if (cursor!=null) {
            cursor.moveToFirst();
            String result = cursor.getString(5);
            cursor.close();
            return result;
        }
        return "";
    }
}
