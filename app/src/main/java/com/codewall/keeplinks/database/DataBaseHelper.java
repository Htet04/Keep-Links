package com.codewall.keeplinks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codewall.keeplinks.data.CateData;
import com.codewall.keeplinks.data.LinkData;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;
    public static final String LINKS_TABLE = "link_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LINK = "link";
    public static final String CATEGORY = "cateogry";
    public static final String NOTE = "note";
    public static final String SAVED_DATE = "saved_date";
    public static final int K_NAME = 1;
    public static final int K_LINK = 2;
    public static final int K_CATEGORY = 3;
    public static final int K_NOTE = 4;
    public static final int K_SAVED_DATE = 5;
    private SQLiteDatabase db;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = " CREATE TABLE " + LINKS_TABLE + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
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

    public long addLink(String name, String link, String category, String note, String saved_date) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(LINK, link);
        values.put(CATEGORY, category);
        values.put(NOTE, note);
        values.put(SAVED_DATE, saved_date);
        return db.insert(LINKS_TABLE, null, values);
    }

    public void updateLink(long id, String name, String link, String category, String note, String saved_date) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(LINK, link);
        values.put(CATEGORY, category);
        values.put(NOTE, note);
        values.put(SAVED_DATE, saved_date);
        db.update(LINKS_TABLE, values, ID + "=" + id, null);
    }

    public void deleteLink(long id) {
        db = this.getWritableDatabase();
        db.delete(LINKS_TABLE, ID + "=" + id, null);
    }

    public int size() {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        int result = 0;
        if (cursor != null) {
            result = cursor.getCount();
            cursor.close();
        }
        return result;
    }

    /**
     * @deprecated အလုပ်ရှုပ်လို့ deprecated ထားထားတယ်
     */
    @Deprecated
    public List<LinkData> getData() {
        List<LinkData> list = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(K_NAME),
                        link = cursor.getString(K_LINK),
                        category = cursor.getString(K_CATEGORY),
                        note = cursor.getString(K_NOTE),
                        date = cursor.getString(K_SAVED_DATE);
                list.add(new LinkData(name, link, category, note, date));
            }
            cursor.close();
        }
        return list;
    }

    public List<CateData> getDa(){
        List<CateData> list=new ArrayList<>();
        db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+LINKS_TABLE,null);
        while (cursor.moveToNext()){
            String name=cursor.getString(K_NAME);
            list.add(new CateData(name));
        }return list;

    }

    public String getValue(int id, int index) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        String result = "";
        if (cursor != null) {
            cursor.moveToPosition(id);
            result = cursor.getString(index);
            cursor.close();
        }
        return result;
    }

/*

        Complex code


    public String getLink(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        cursor.moveToFirst();
        String result = cursor.getString(1);
        cursor.close();
        return result;
    }
    public String getCategory(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        cursor.moveToFirst();
        String result = cursor.getString(2);
        cursor.close();
        return result;
    }
    public String getNote(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        cursor.moveToFirst();
        String result = cursor.getString(3);
        cursor.close();
        return result;
    }
    public String getSavedDate(long id) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        cursor.moveToFirst();
        String result = cursor.getString(4);
        cursor.close();
        return result;
    }*/
}
