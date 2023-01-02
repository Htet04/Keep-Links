package com.codewall.keeplinks.data.model;

import java.util.List;

public class Category {
    private String category;
    private List<String> links;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
