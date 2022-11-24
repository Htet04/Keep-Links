package com.ktz.keeplinks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase database;
    List<Contacts> arrayList=new ArrayList<>();
    private static final String DATABASE_NAME = "hi.db";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table users(title TEXT primary key )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        onCreate(db);

    }
    public Boolean saveDate(String title){
        database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",title);
        long result=database.insert("users",null,contentValues);
        if(result==-1){
            return  false;
        }else{
            return true;
        }

    }
    public List<Contacts> getAllContacts() {
            database=this.getReadableDatabase();
            String columns[] = {"title"};
            Cursor cursor = database.query("users", columns, null, null, null, null, null);
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex("title");
                String title = cursor.getString(index);

                Contacts contacts = new Contacts(title);
                arrayList.add(contacts);
            }
            return arrayList;
}}
