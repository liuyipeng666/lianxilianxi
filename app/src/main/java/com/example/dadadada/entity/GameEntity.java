package com.example.dadadada.entity;

public class GameEntity {



    private int image_url;
    private String name;

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public GameEntity(int image_url, String name) {
        this.image_url = image_url;
        this.name = name;
    }
}
