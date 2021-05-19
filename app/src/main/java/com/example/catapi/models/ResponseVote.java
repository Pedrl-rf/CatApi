package com.example.catapi.models;

public class ResponseVote {
    private int id;
    private String message;

    public ResponseVote(String message,int id ){
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
