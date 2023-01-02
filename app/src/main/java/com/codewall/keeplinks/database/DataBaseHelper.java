package com.codewall.keeplinks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codewall.keeplinks.data.model.Category;
import com.codewall.keeplinks.data.model.Home;
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

    public ArrayList<Home> getHomeData() {
        ArrayList<Home> data = new ArrayList<>();
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

    // TODO: Un-finish method
    public ArrayList<Category> getCategory() {
        db = this.getReadableDatabase();

        // return ပြန်မယ့်ဒေတာ
        ArrayList<Category> data = new ArrayList<>();

        // Table ထဲမှာရှိတဲ့ content တွေ အကုန်ယူမယ် ပြီးရင် category အလိုက်စစ်ထည့်ပြီး အပေါ်က data ထဲပြန်ထည့်မယ်
        List<Home> unFilterData = getHomeData();

        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        // Content တစ်ခုချင်းရဲ့ position ကိုယူသုံးဖို့
        int n = 0;

        for (Home map : unFilterData) {
            // Category အလိုက် link တွေကို စုထားဖို့
            List<String> links = new ArrayList<>();
            // Category Data class
            Category category;
            if (data.size() > 0 && data.get(n).getCategory().contains(map.getCategory())) {
                // null Object Reference မဖြစ်ဖု့ obj size အနည်းဆုံးတစ်ခုရှိမှ && အနောက်က condition ဆက် စစ်မယ်
                // data size က 0 ထက်ကြီးရင် return ပြန်မယ့် data ထဲ ဒီ Category ရှိရင်
                // အဲ့ဒီ links List ကိုယူမယ်
                links = data.get(n).getLinks();
                // link အသစ် ထပ်ထည့်မယ်
                links.add(map.getLink());
                // n ကြိမ်မြောက်မှာရှိတဲ့ Category data ကို ယူမယ်
                category = data.get(n);
                // link အသစ်ထည့်ထားတဲ့ links List ကို ထည့်ပေးလိုက်မယ်
                category.setLinks(links);
                // data ထဲ n ကြိမ်မြောက်မှာ link အသစ်ပါတဲ့ Category data ကို update လိုက်မယ်
                data.set(n, category);
            } else {
                // data size 0 (Zero) ဖြစ်ရင် အသစ်ထပ်ထည့်ဖို့
                // data တစ်ခုထည့်ပြီတာနဲ့ data size တိုးသွားပြီမို့ ဆက်မလုပ်တော့ဘူး
                // Category အသစ်အတွက် တစ်ခါ ပဲ အလုပ်လုပ်တယ် ရှိပြီးသား Category အတွက်ဆို
                // အပေါ်က condition က အလုပ်လုပ်မယ်

                category = new Category();
                // Category name ထည့်မယ်
                category.setCategory(map.getCategory());
                //links ထဲကို link ထည့်မယ်
                links.add(map.getLink());
                //links List ကို Category data ထဲထည့်မယ်
                category.setLinks(links);
                //Category name နဲ့ သူ့ရဲ့ links ကို data ထဲထည့်မယ်
                data.add(category);
            }

        }
        cursor.close();
        Log.i(TAG, "getCategory: \n" + new Gson().toJson(data));
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
