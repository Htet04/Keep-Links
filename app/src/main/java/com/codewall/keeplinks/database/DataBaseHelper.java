package com.codewall.keeplinks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.data.HomeData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
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

    public HomeData getHomeData(){
        HomeData data = new HomeData();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+LINKS_TABLE,null);
        while (cursor.moveToNext()){
            HashMap<String,String> map = new HashMap<>();
            map.put(NAME,cursor.getString(1));
            map.put(LINK,cursor.getString(2));
            map.put(CATEGORY,cursor.getString(3));
            map.put(NOTE,cursor.getString(4));
            map.put(SAVED_DATE,cursor.getString(5));
            data.add(map);
        }
        cursor.close();
        return data;
    }

    // TODO: Un-finish method
    public CategoryData getCategory() {
        CategoryData data = new CategoryData();
        // arrange the values by programming
        List<HashMap<String,String>> list = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        int n = 0;
        while (cursor.moveToNext()) {
            String category = cursor.getString(K_CATEGORY),
                    link = cursor.getString(K_LINK);
            HashMap<String,String> map = new HashMap<>();
            map.put("category",category);
            map.put("link",link);
            list.add(map);
        }
        for (HashMap<String, String> map:
        list){
            HashMap<String,Object> map1 = new HashMap<>();
            List<String> links = new ArrayList<>();
            if (data.size()>0&&data.get(n).containsValue(map.get("category"))){
                links = (List<String>) data.get(n).get("links");
                links.add(map.get("link"));
                map1.replace("links",links);
                data.set(n,map1);
            }else {
                map1.put("category",map.get("category"));
                links.add(map.get("link"));
                map1.put("links",links);
                data.add(map1);
            }
        }
        cursor.close();
        Log.i(TAG, "getCategory: \n"+new Gson().toJson(data));
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
