package com.codewall.keeplinks.data;

import com.codewall.keeplinks.data.model.Home;
import com.codewall.keeplinks.database.DataBaseHelper;

import java.util.ArrayList;

//TODO : need to edit data many method have been tried but have a lot of problem done!
public class HomeData extends ArrayList<Home> {
    private DataBaseHelper db;

    public HomeData(DataBaseHelper db) {
        this.db = db;
    }

    public void addToDb(Home home) {
        db.addLink(home.getNAME(),home.getLINK(),home.getCATEGORY(),home.getNOTE(),home.getSAVEDDATE());
        add(home);
    }

    public void rm(int position){
        super.remove(position);
        db.deleteLink(position+1);
    }

    public void set(int position){
        Home home = get(position);
    }
}
