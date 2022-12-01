package com.codewall.keeplinks.data;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryData extends ArrayList<HashMap<String,Object>> {

    private HashMap<String, Object> map;
    private List<String> links;

    public CategoryData(){

    }

    /**
     * Add Category Only*/
    public void add(String category){
        links = new ArrayList<>();
        this.add(category,links);
    }

    /**
     * Add Category Super Method*/
    public boolean add(String category,List<String> links) {
        map = new HashMap<>();
        map.put("category",category);
        map.put("links",links);
        return super.add(map);
    }

    /**
     * Add Link to an Exist Category*/
    public void addLink(String category, String link){
        List<String> l = new ArrayList<>();
        if (contains(category)) {
            l = getLinks(category);
        }
        this.add(category,l);
    }

    /**
     * Check is Category contained*/
    public boolean contains(String category) {
        return super.contains(category);
    }

    /**
     * Get All link from an Category*/
    public List<String> getLinks(String category){
        links = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).get("category").toString().equals(category)){
                links = (List<String>) this.get(i).get("links");
            }
        }
        return links;
    }

    /**
     * Get the size of link from an Category*/
    public int linkSize(String category){
        return getLinks(category).size();
    }
}
