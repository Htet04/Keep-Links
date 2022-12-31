package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeData {
    private ArrayList<HashMap<String,String>> data;
    private Context context;

    public HomeData(Context context) {
        this.context = context;
        data = new DataBaseHelper(context).getHomeData();
    }

    public int size() {
        return data.size();
    }

    public void remove(int position) {
        data.remove(position);
    }

    public String getName(int position) {
        return (String) data.get(position).get(DataBaseHelper.NAME);
    }

    public String getLink(int position) {
        return (String) data.get(position).get(DataBaseHelper.LINK);
    }

    public String getCategory(int position) {
        return (String) data.get(position).get(DataBaseHelper.CATEGORY);
    }

    public String getNote(int position) {
        return (String) data.get(position).get(DataBaseHelper.NOTE);
    }

    public String getSavedDate(int position) {
        return (String) data.get(position).get(DataBaseHelper.SAVED_DATE);
    }
    // TODO : inject database add,delete,update method here to make it fresh.

}
