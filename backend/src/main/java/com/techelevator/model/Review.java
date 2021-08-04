package com.techelevator.model;

public class Review {

    private long id;
    private String reviewName;
    private String text;
    private int starCount;
    private String type;
    private long userId;


    public Review(long id, String reviewName, String text, int starCount, String type, long userId) {
        this.id = id;
        this.reviewName = reviewName;
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

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
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
