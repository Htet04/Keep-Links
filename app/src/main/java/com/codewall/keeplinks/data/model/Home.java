package com.codewall.keeplinks.data.model;

public class Home {
    private String name,link,category,savedDate,note;

    public Home(){
        //empty constructor
    }

    public Home(String name, String link, String category, String savedDate, String note) {
        this.name = name;
        this.link = link;
        this.category = category;
        this.savedDate = savedDate;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(String savedDate) {
        this.savedDate = savedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
