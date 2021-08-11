package com.techelevator.controller;

import java.util.List;

import com.techelevator.dao.FeaturedBeerDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.model.FeaturedBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;


@RestController
@CrossOrigin
public class BeerController {

    @Autowired
    BeerDao beerDao;
    @Autowired
    FeaturedBeerDao featuredBeerDao;

    @GetMapping(path = "/breweries/{breweryId}/beers")
    public List<Beer> getBeersByBreweryId(@PathVariable int breweryId) {
        List<Beer> beerList = beerDao.getBeersByBreweryId(breweryId);
        return beerList;
    }

    @GetMapping(path="/breweries/{breweryId}/beers/{id}")
    public Beer getBeerById(@PathVariable int breweryId, @PathVariable int id) {
        Beer beer = beerDao.getBeerById(breweryId, id);
        return beer;
    }

    @PostMapping(path= "/account/breweries/{breweryId}/beers/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBeer(@RequestBody Beer b) {
        beerDao.addBeer(b);
    }

    @DeleteMapping(path="/account/breweries/{breweryId}/beers")
    public void deleteBeer(@RequestParam long beerId) {
        beerDao.deleteBeer(beerId);
    }

    @DeleteMapping(path="/beers/{breweryId}")
    public void deleteBeersByBrewery(@PathVariable int id) {
        beerDao.deleteBeer(id);
    }

    @PutMapping(path="/account/breweries/{breweryId}/beers/{beerId}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateBeer(@RequestBody Beer b) {
        beerDao.updateBeer(b);
    }

    @GetMapping(path ="/beers/random")
    public FeaturedBeer getRandomBeer() {
        FeaturedBeer featuredBeer = featuredBeerDao.getRandomBeer();
        return featuredBeer;
    }










}
