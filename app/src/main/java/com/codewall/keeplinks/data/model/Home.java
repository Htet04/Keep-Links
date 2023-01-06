package com.codewall.keeplinks.data.model;

import java.util.HashMap;

public class Home extends HashMap<String,String> {
    private final String NAME ="name",
            LINK ="link",
            CATEGORY ="category",
            SAVEDDATE ="savedDate",
            NOTE ="note";

    public String getNAME() {
        return get(NAME);
    }

    public String getLINK() {
        return get(LINK);
    }

    public String getCATEGORY() {
        return get(CATEGORY);
    }

    public String getSAVEDDATE() {
        return get(SAVEDDATE);
    }

    public String getNOTE() {
        return get(NOTE);
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
        put(SAVEDDATE,saveddate);
        return this;
    }

    public Home setNote(String note){
        put(NOTE,note);
        return this;
    }
}
