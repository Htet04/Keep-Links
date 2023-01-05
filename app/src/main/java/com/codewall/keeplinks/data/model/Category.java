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
}
