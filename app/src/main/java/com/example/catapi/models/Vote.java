package com.example.catapi.models;

public class Vote {
    private String image_id,sub_id;
    private int value;

    public Vote(String image_id, String sub_id, int value) {
        this.image_id = image_id;
        this.sub_id = sub_id;
        this.value = value;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

