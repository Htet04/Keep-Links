package com.codewall.keeplinks.data.model;

import java.util.List;

public class Category {
    private String category;
    private List<Integer> id;

    public Category() {
        //empty constructor
    }

    public Category(String category, List<Integer> links) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Integer> getIds() {
        return id;
    }

    public void setIds(List<Integer> id) {
        this.id = id;
    }
}
