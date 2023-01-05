package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.data.model.Category;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryData extends ArrayList<Category> {
    // TODO : inject database add,delete,update method here to make it fresh.
    private Context context;
    private DataBaseHelper db;
    public CategoryData getInstance(Context context){
        this.context = context;
        db = new DataBaseHelper(context);
        return db.getCategory();
    }
}
