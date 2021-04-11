package com.playground.beans;

import jakarta.annotation.PostConstruct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CatListBean implements Serializable {

    private List<Category> categoryList;

    @PostConstruct
    public  void init(){
        categoryList = new ArrayList<>();

        categoryList.add(new Category("games","games",0));
        categoryList.add(new Category("consoles","consoles",0));
        categoryList.add(new Category("VR","VR",0));
        categoryList.add(new Category("Pads","Pads",0));
        categoryList.add(new Category("Joysticks","Joysticks",0));
        categoryList.add(new Category("Headsets","Headsets",0));
    }


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void incCategory(String name){
        categoryList.stream().filter(category -> category.getLabel().equals(name)).forEach(category -> {
            category.setVotes( category.getVotes() + 1 );
        });
        System.out.println(categoryList);
    }


    @Override
    public String toString() {
        return "CatListBean{" +
                "categoryList=" + categoryList +
                '}';
    }
}
