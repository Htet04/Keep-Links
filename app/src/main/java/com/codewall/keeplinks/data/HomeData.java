package com.codewall.keeplinks.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.codewall.keeplinks.data.model.Home;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;

//TODO : need to edit data many method have been tried but have a lot of problem done!
public class HomeData extends DataBaseHelper {
    private ArrayList<Home> data;
    private HashMap<String,String> map;
    private Context context;

    public HomeData(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        data = new DataBaseHelper(context).getHomeData();
    }

    public void add(String name,String link,String category,String savedDae,String note){
        super.addLink(name, link, category, savedDae, note);
    }

    public void set(int id,String name,String link,String category,String savedDae,String note){
        super.updateLink(id+1,name,link,category,savedDae,note);
    }

    public int size() {
        return data.size();
    }

    public void remove(int position) {
        data.remove(position);
    }

    public String getName(int position) {
        return data.get(position).getName();
    }

    public String getLink(int position) {
        return data.get(position).getLink();
    }

    public String getCategory(int position) {
        return data.get(position).getCategory();
    }

    public String getNote(int position) {
        return data.get(position).getNote();
    }

    public String getSavedDate(int position) {
        return data.get(position).getSavedDate();
    }
    // TODO : inject database add,delete,update method here to make it fresh.

}
