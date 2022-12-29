package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryData extends ArrayList<HashMap<String, Object>> {
    // TODO : inject database add,delete,update method here to make it fresh.

    public static CategoryData getInstance(Context context){
        return new DataBaseHelper(context).getCategory();
    }
}
