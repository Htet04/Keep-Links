package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryData extends DataBaseHelper {
    // TODO : inject database add,delete,update method here to make it fresh.
    private ArrayList<HashMap<String, Object>> data;
    private DataBaseHelper db;
    private Context context;

    public CategoryData(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        db = new DataBaseHelper(this.context);
    }

    public int size() {
        return data.size();
    }

    public void add() {

    }

    public Map<String, Object> get(int position) {
        return data.get(position);
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
}
