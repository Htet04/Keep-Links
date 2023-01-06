package com.codewall.keeplinks.data;

import android.util.Log;

import com.codewall.keeplinks.data.model.Category;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;

public class CategoryData extends ArrayList<Category> {
    // TODO : inject database add,delete,update method here to make it fresh.
    private DataBaseHelper db;

    public CategoryData(DataBaseHelper db) {
        this.db = db;
    }

    public void setCategory(int position, String str) {
        Category category = get(position);
        Log.i("caterr", "setCategory: " + category.getCategory());
        category.setCategory(str);
        this.set(position, category);

        for (int n :
                category.getIds()) {
            db.setCategory(n, str);
        }
    }
}
