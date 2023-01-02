package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.data.model.Category;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryData extends DataBaseHelper {
    // TODO : inject database add,delete,update method here to make it fresh.
    private ArrayList<Category> data;
    private Context context;

    public CategoryData(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        data = new DataBaseHelper(this.context).getCategory();
    }

    public int size() {
        return data.size();
    }

    public void add() {

    }
}
