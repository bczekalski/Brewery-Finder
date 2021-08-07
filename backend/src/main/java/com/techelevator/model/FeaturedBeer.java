package com.techelevator.model;

public class FeaturedBeer {
    private String brands;
    private String product_name;
    private String image_url;
    private String allergens;
    private long _id;

    public FeaturedBeer() {

    }

    public FeaturedBeer(String brands, String product_name, String image_url, String allergens, long _id) {
        this.brands = brands;
        this.product_name = product_name;
        this.image_url = image_url;
        this.allergens = allergens;
        this._id = _id;
    }

    public String getBrands() {
        return brands;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getAllergens() {
        return allergens;
    }

    public long get_id() {
        return _id;
    }
}

