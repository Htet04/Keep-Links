package com.codewall.keeplinks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.data.model.Category;
import com.codewall.keeplinks.data.model.Home;

import java.util.ArrayList;
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
        db.close();
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
        HomeData data = new HomeData(this);
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE, null);
        while (cursor.moveToNext()) {
            data.add(new Home().setName(cursor.getString(1))
                            .setLink(cursor.getString(2))
                            .setCategory(cursor.getString(3))
                            .setNote(cursor.getString(4))
                    .setSavedDate(cursor.getString(5)));
        }
        cursor.close();
        return data;
    }

    //Category Section
    public CategoryData getCategory() {
        db = this.getReadableDatabase();
        CategoryData data = new CategoryData(this);
        List<Integer> ids = new ArrayList<>();

        //temp data
        List<String> cat = new ArrayList<>();
        Cursor cg = db.rawQuery("SELECT " + CATEGORY + " FROM " + LINKS_TABLE + " GROUP BY " + CATEGORY + ";", null);
        while (cg.moveToNext()) {
            cat.add(cg.getString(0));
        }
        for (String s : cat) {
            Cursor cursor = db.rawQuery("SELECT " + ID + "," + CATEGORY +
                    " FROM " + LINKS_TABLE +
                    " WHERE " + CATEGORY + "='" + s + "';", null);
            ids = new ArrayList<>();
            while (cursor.moveToNext()) {
                ids.add(Integer.valueOf(cursor.getString(0)));
            }
            Category c = new Category();
            c.setCategory(s);
            c.setIds(ids);
            data.add(c);

            cursor.close();
        }
        cg.close();
        return data;
    }

    public void setCategory(long id, String category) {
        //TODO : edit category only
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LINKS_TABLE + " WHERE id=" + id, null);
        cursor.moveToNext();
        String name = cursor.getString(K_NAME),
                link = cursor.getString(K_LINK),
                note = cursor.getString(K_NOTE),
                sd = cursor.getString(K_SAVED_DATE);
        updateLink(id, name, link, category, note, sd);
        cursor.close();
        db.close();
    }

    //end of Category section

    @Deprecated
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
