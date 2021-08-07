package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import com.techelevator.dao.JdbcBreweryDao;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDao breweryDao;

    public BreweryController (BreweryDao breweryDao, UserDao userDao) {
        this.breweryDao = breweryDao;
    }

    @GetMapping(path = {"/breweries"})
    public List<Brewery> getAllBreweries() {
        List<Brewery> breweryList = breweryDao.getAllBreweries();
        return breweryList;
    }

    @GetMapping(path = "/breweries/{id}")
    public Brewery getBreweryById(@PathVariable int id) {
        return breweryDao.getBreweryById(id);
    }

    @GetMapping(path = "/account/breweries")
    @PreAuthorize("hasRole('ROLE_BREWER')")
    public List<Brewery> getBreweryByUserId(@RequestParam int id){
        return breweryDao.getBreweryByUserId(id);
    }

    @DeleteMapping(path = "/breweries/{id}")
    @PreAuthorize("hasRole('ROLE_BREWER')")
    public void deleteBrewery(@PathVariable int id) {
        breweryDao.deleteBrewery(id);
    }

    @PutMapping(path = "account/breweries/{breweryId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBrewery(@RequestBody Brewery breweryToUpdate) {
        breweryDao.updateBrewery(breweryToUpdate);
    }

    @PostMapping(path = {"/breweries"})
    @ResponseStatus(HttpStatus.CREATED)
    public void addBrewery(@RequestBody Brewery newBrewery) {
        breweryDao.createBrewery(newBrewery);
    }

    @GetMapping(path = "/breweries/glutenfree")
    public List<Brewery> getAllBreweriesWithGFBeer() {
        List<Brewery> glutenFreeBeers = breweryDao.getAllBreweriesWithGFBeer();
        return glutenFreeBeers;
    }


}
