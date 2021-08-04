package com.techelevator.controller;

import java.util.List;

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
    BeerDao Beer1;

    @GetMapping(path= {"/beers"})
    public List<Beer> getListOfBeers(){
        List<Beer> beerList = Beer1.getBeers();
        return beerList;
    }

    @GetMapping(path="/breweries/{breweryId}/beers/{id}")
    public Beer getBeerById(@PathVariable int breweryId, @PathVariable int id) {
        Beer beer = Beer1.getBeerById(breweryId, id);
        return beer;
    }

    @PostMapping(path= {"/beers"})
    @ResponseStatus(HttpStatus.CREATED)
    public void addBeer(@RequestBody Beer b) {
        Beer1.addBeer(b);
    }

    @DeleteMapping(path="/beers/{id}")
    public void deleteBeer(@PathVariable int id) {
        Beer1.deleteBeer(id);
    }

    @DeleteMapping(path="/beers/{breweryId}")
    public void deleteBeersByBrewery(@PathVariable int id) {
        Beer1.deleteBeer(id);
    }

    @PutMapping(path="/updateBeer")
    @ResponseStatus(HttpStatus.OK)
    public void updateBeer(@RequestBody Beer b) {
        Beer1.updateBeer(b);
    }










}
