package com.techelevator.dao;

import java.util.List;
import com.techelevator.model.Beer;

public interface BeerDao {
    List<Beer> getBeers();

    Beer getBeerById(int breweryId, int id);

    long addBeer(Beer beerToInsert);

    void deleteBeer(int id);

    void deleteBeersByBrewery(int breweryId);

    //List<Beer> getAllGlutenFreeBeers();

    List<Beer> getBeersByBreweryId(int breweryId);

    void updateBeer(Beer beerToUpdate);

}
