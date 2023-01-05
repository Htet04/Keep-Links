package com.codewall.keeplinks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.data.model.Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DataBaseHelper";

    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;
    public static final String LINKS_TABLE = "link_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LINK = "link";
    public static final String CATEGORY = "category";
    public static final String NOTE = "note";
    public static final String SAVED_DATE = "saved_date";
    public static final int K_NAME = 1;
    public static final int K_LINK = 2;
    public static final int K_CATEGORY = 3;
    public static final int K_NOTE = 4;
    public static final int K_SAVED_DATE = 5;

    private final String[] columns = {ID, NAME, LINK, CATEGORY, SAVED_DATE, NOTE};

    private Context context;
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

    public HomeData getHomeData() {
        HomeData data = new HomeData();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        while (cursor.moveToNext()) {
            Home map = new Home(cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5));
            data.add(map);
        }
        cursor.close();
        return data;
    }

    public CategoryData getCategory() {
        db = this.getReadableDatabase();

        // return ပြန်မယ့်ဒေတာ
        CategoryData data = new CategoryData();

        // TODO: edit here
        Cursor cursorGp = db.rawQuery("SELECT " + CATEGORY + " FROM " + LINKS_TABLE + " GROUP BY " + CATEGORY, null);
        List<String> cg = new ArrayList<>();
        List<Integer> cid = new ArrayList<>();
        while (cursorGp.moveToNext()) {
            cg.add(cursorGp.getString(0));
        }
        StringBuilder builder = new StringBuilder();

        for (String s :
                cg) {
            Cursor cursor = db.rawQuery("SELECT id FROM " + LINKS_TABLE + " WHERE " + CATEGORY + " ='"+s+"'", null);

            cid = new ArrayList<>();
            while (cursor.moveToNext()) {
                cid.add(Integer.valueOf(cursor.getString(0)));
/*
                builder.append("Name: ").append(cursor.getString(K_NAME)).append("\n")
                        .append("Link: ").append(cursor.getString(K_LINK)).append("\n")
                        .append("Cate: ").append(cursor.getString(K_CATEGORY)).append("\n")
                        .append("Sd: ").append(cursor.getString(K_SAVED_DATE)).append("\n")
                        .append("Note: ").append(cursor.getString(K_NOTE)).append("\n\n");
*/
            }
            cursor.close();
            Log.i(TAG, "getCategory: ".concat(Arrays.deepToString(cid.toArray())));
        }

        cursorGp.close();
        return data;
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
}
