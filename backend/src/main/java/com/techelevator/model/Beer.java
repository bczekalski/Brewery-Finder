package com.techelevator.model;

public class Beer {

    private long beerId;
    private String name;
    private String description;
    private String beerType;
    private Double abv;
    private String imageLink;
    private boolean glutenFree;
    private long breweryId;

    public Beer() {

    }

    public Beer(long beerId, String name, String description, String beerType, Double abv, String imageLink, long breweryId) {
        this.beerId = beerId;
        this.name = name;
        this.description = description;
        this.beerType = beerType;
        this.abv = abv;
        this.imageLink = imageLink;
        this.glutenFree = false;
        this.breweryId = breweryId;
    }



    public long getBeerId() {
        return beerId;
    }

    public void setBeerId(long beerId) {
        this.beerId = beerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public long getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(long breweryId) {
        this.breweryId = breweryId;
    }
}
