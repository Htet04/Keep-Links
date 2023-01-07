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
        db.addLink(home.getName(),home.getLink(),home.getCategory(),home.getNote(),home.getSavedDate());
        add(home);
    }

    public void rm(int position){
        db.deleteLink(getId(position));
        super.remove(position);
    }

    public void set(int position){
        Home home = get(position);
    }

    public int getId(int position){
        return Integer.parseInt(get(position).getId());
    }

    public String getName(int position){
        return get(position).getName();
    }
    public String getLink(int position){
        return get(position).getLink();
    }
    public String getCategory(int position){
        return get(position).getCategory();
    }
    public String getNote(int position){
        return get(position).getNote();
    }
    public String getSavedDate(int position){
        return get(position).getSavedDate();
    }

}
