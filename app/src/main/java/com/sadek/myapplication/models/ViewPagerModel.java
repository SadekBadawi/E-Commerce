package com.sadek.myapplication.models;

public class ViewPagerModel {
    private Integer image;

    private String title;

    private String body;

    public ViewPagerModel(Integer image, String title, String body) {
        this.image = image;
        this.title = title;
        this.body = body;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
