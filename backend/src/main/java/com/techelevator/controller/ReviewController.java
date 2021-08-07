package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Review;

@RestController
@CrossOrigin
public class ReviewController {

    @Autowired
    ReviewDao reviews;

    @Autowired
    UserDao users;

    @GetMapping(path="/breweries/{breweryId}/reviews")
    public List<Review> getBreweryReviews(@PathVariable int breweryId){
        String type = "Brewery";
        return reviews.getAllReviewsByTargetId(breweryId, type);
    }

    @GetMapping(path="/account/reviews")
    @PreAuthorize("isAuthenticated()")
    public List<Review> getUserReviews(Principal principal){
        return reviews.getAllReviewsByUserId(users.findByUsername(principal.getName()).getId());
    }

    @GetMapping(path="/breweries/{breweryId}/beers/{beerId}/reviews")
    public List<Review> getBeerReviews(@PathVariable int beerId){
        String type = "Beer";
        return reviews.getAllReviewsByTargetId(beerId, type);
    }

    @PutMapping(path="/editReview/{reviewId}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review) {
        reviews.updateReview(review);
    }

    @DeleteMapping(path="/account/reviews")
    @PreAuthorize("isAuthenticated()")
    public void deleteReviews(@PathVariable int userId) {
        reviews.deleteReviews(userId);
    }

    @PostMapping(path="/breweries/{breweryId}/reviews")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody Review r) {
        reviews.createReview(r);
    }

    /*@GetMapping(path="/reviews/review/{reviewId}")
    public Review getReviewsByReviewId(@PathVariable int reviewId){
        Review userReviews = reviews.getReviewByReviewId(reviewId);
        return userReviews;
    }*/











}
