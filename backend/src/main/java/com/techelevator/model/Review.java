package com.techelevator.model;

public class Review {

    private long id;
    private String name;
    private String text;
    private int starCount;
    private String type;
    private long userId;

    public Review(long id, String name, String text, int starCount, String type, long userId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.starCount = starCount;
        this.type = type;
        this.userId = userId;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
