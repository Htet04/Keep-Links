package com.codewall.keeplinks.data;

import android.content.Context;

import com.codewall.keeplinks.data.model.Home;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;

//TODO : need to edit data many method have been tried but have a lot of problem done!
public class HomeData extends ArrayList<Home> {
    private Context context;
    private DataBaseHelper db;
    public HomeData getInstance(Context context){
        this.context = context;
        db = new DataBaseHelper(context);
        return db.getHomeData();
    }
}
