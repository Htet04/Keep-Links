package com.codewall.keeplinks.data;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryData extends ArrayList<HashMap<String,Object>> {

    HashMap<String, Object> map;
    List<String> links;

    public CategoryData(){

    }

    public boolean add(String category,List<String> links) {
        map = new HashMap<>();
        map.put("category",category);
        map.put("links",links);
        return super.add(map);
    }

    public boolean contains(String category) {
        return super.contains(category);
    }

    public void addLink(String category, String link){
        List<String> l = new ArrayList<>();
        if (contains(category)) {
            l = getLinks(category);
        }
        this.add(category,l);
    }

    public List<String> getLinks(String category){
        links = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).get("category").toString().equals(category)){
                links = (List<String>) this.get(i).get("links");
            }
        }
        return links;
    }

    public int linkSize(String category){
        return getLinks(category).size();
    }
}
