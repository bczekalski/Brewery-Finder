package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;

public interface BeerDao {

    List<Beer> getBeers();
    Beer getBeerById(int breweryId, int id);
    long addBeer(Beer newBeer);
    void deleteBeer(int id);
    void deleteBeersByBrewery(int breweryId);
    void updateBeer(Beer beerToUpdate);




}
