package com.techelevator.controller;

import java.util.List;

import com.techelevator.dao.FeaturedBeerDao;
import com.techelevator.model.FeaturedBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path= {"/beers"})
    @ResponseStatus(HttpStatus.CREATED)
    public void addBeer(@RequestBody Beer b) {
        beerDao.addBeer(b);
    }

    @DeleteMapping(path="/beers/{id}")
    public void deleteBeer(@PathVariable int id) {
        beerDao.deleteBeer(id);
    }

    @DeleteMapping(path="/beers/{breweryId}")
    public void deleteBeersByBrewery(@PathVariable int id) {
        beerDao.deleteBeer(id);
    }

    @PutMapping(path="/updateBeer")
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
