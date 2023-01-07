package com.codewall.keeplinks.data.model;

import static com.codewall.keeplinks.database.DataBaseHelper.CATEGORY;
import static com.codewall.keeplinks.database.DataBaseHelper.ID;
import static com.codewall.keeplinks.database.DataBaseHelper.LINK;
import static com.codewall.keeplinks.database.DataBaseHelper.NAME;
import static com.codewall.keeplinks.database.DataBaseHelper.NOTE;
import static com.codewall.keeplinks.database.DataBaseHelper.SAVED_DATE;

import java.util.HashMap;

public class Home extends HashMap<String,String> {

    public Home() {
        //empty constructor
    }

    public Home(String id,String name,String link,String cate,String note,String sd){
        setId(id).setName(name).setLink(link).setCategory(cate).setNote(note).setSavedDate(sd);
    }

    public String getId(){
        return get(ID);
    }

    public String getName() {
        return get(NAME);
    }

    public String getLink() {
        return get(LINK);
    }

    public String getCategory() {
        return get(CATEGORY);
    }

    public String getSavedDate() {
        return get(SAVED_DATE);
    }

    public String getNote() {
        return get(NOTE);
    }

    public Home setId(String id){
        put(ID,id);
        return this;
    }

    public Home setName(String name){
        put(NAME,name);
        return this;
    }

    public Home setLink(String link){
        put(LINK,link);
        return this;
    }

    public Home setCategory(String category){
        put(CATEGORY,category);
        return this;
    }

    public Home setSavedDate(String saveddate){
        put(SAVED_DATE,saveddate);
        return this;
    }

    public Home setNote(String note){
        put(NOTE,note);
        return this;
    }
}
