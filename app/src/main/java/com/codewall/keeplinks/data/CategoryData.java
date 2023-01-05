package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.data.model.Category;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;

public class CategoryData extends ArrayList<Category> {
    // TODO : inject database add,delete,update method here to make it fresh.
    private Context context;
    private DataBaseHelper db;

    public CategoryData getInstance(Context context) {
        this.context = context;
        db = new DataBaseHelper(context);
        return db.getCategory();
    }

    public void setCategory(int position, String str) {
        Category category = get(position);
        category.setCategory(str);
        set(position, category);
        for (int n :
                category.getIds()) {
            db.setCategory(n,str);
        }
    }
}
