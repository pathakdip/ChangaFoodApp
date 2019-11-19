package com.example.changafoodapp.model;

public class Food {

    private String title,imgUrl,price;

    public Food() {
    }

    public Food(String title,String price,String imgUrl) {
        this.title = title;
        this.price=price;
        this.imgUrl=imgUrl;

    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }
}
