package com.example.changafoodapp.model;

public class Food {

    private String title,imgUrl;

    public Food() {
    }

    public Food(String title,String imgUrl) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }
}
