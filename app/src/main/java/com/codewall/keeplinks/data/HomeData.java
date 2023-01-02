package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.data.model.Home;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;

//TODO : need to edit data many method have been tried but have a lot of problem done!
public class HomeData extends DataBaseHelper {
    private ArrayList<Home> data;
    private final Context context;

    public HomeData(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        data = new DataBaseHelper(context).getHomeData();
    }

    public void add(String name, String link, String category, String savedDate, String note) {
        super.addLink(name, link, category, savedDate, note);
        data.add(new Home(name, link, category, savedDate, note));
    }

    public void set(int id, String name, String link, String category, String savedDate, String note) {
        super.updateLink(id + 1, name, link, category, savedDate, note);
        data.set(id, new Home(name, link, category, savedDate, note));
    }

    public void rm(int id) {
        super.deleteLink(id + 1);
        data.remove(id);
    }


    public int size() {
        return data.size();
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
