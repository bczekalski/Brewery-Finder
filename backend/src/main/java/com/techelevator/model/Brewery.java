package com.techelevator.model;
public class Brewery {

    private long id;
    private String name;
    private String contactInfo;
    private String history;
    private String operationTime;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String website;
    private boolean active = true;
    private long foodServedId;
    private String image;

    public Brewery(long id, String name, String contactInfo, String history, String operationTime, String address,
                   String city, String state, String zipCode, String website, long foodServedId, String image) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.history = history;
        this.operationTime = operationTime;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.website = website;
        this.image = image;
        this.foodServedId = foodServedId;
        this.image = image;
        this.active = active;
    }

    public Brewery() {}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        active = active;
    }

    public long getFoodServedId() {
        return foodServedId;
    }

    public void setFoodServedId(long foodServedId) {
        this.foodServedId = foodServedId;
    }
}
