package com.techelevator.dao;

import java.util.List;
import com.techelevator.model.Brewery;
import com.techelevator.model.Beer;

public interface BreweryDao {

    List<Brewery> getAllBreweries();

    Brewery getBreweryById(int id);

    long createBrewery(Brewery newBrewery);

    void deleteBrewery(int id);

    void updateBrewery(Brewery aBrewery);

    List<Brewery> getAllBreweriesWithGFBeer();
}