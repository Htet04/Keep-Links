package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeData extends ArrayList<HashMap<String,String>> {
    // TODO : inject database add,delete,update method here to make it fresh.
    public static HomeData getInstance(Context context){
        return new DataBaseHelper(context).getHomeData();
    }
}
