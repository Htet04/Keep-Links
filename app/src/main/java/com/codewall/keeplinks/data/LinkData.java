package com.codewall.keeplinks.data;

public class LinkData {
    private String name,link,category,note,date;

    public LinkData(String name, String link, String category, String note, String date) {
        this.name = name;
        this.link = link;
        this.category = category;
        this.note = note;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getCategory() {
        return category;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }
}
