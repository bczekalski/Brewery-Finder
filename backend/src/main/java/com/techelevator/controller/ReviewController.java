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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Review;

@RestController
@CrossOrigin
public class ReviewController {

    @Autowired
    ReviewDao reviews;
    @GetMapping(path="/breweries/{breweryId}/reviews")
    public List<Review> getBreweryReviews(@PathVariable int breweryId){
        String type = "Brewery";
        return reviews.getAllReviewsByTargetId(breweryId, type);
    }

    @GetMapping(path="/breweries/{breweryId}/beers/{beerId}/reviews")
    public List<Review> getBeerReviews(@PathVariable int beerId){
        String type = "Beer";
        return reviews.getAllReviewsByTargetId(beerId, type);
    }

    @PutMapping(path="/editReview/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review) {
        reviews.updateReview(review);
    }

    @DeleteMapping(path="/reviews/{userId}/delete")
    public void deleteReviews(@PathVariable int userId) {
        reviews.deleteReviews(userId);
    }

    @PostMapping(path="/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody Review r) {
        reviews.createReview(r);
    }

    @GetMapping(path="/reviews/{userId}")
    public List<Review> getAllReviewsByUserId(@PathVariable int userId){
        List<Review> userReviews = reviews.getAllReviewsByUserId(userId);
        return userReviews;
    }

    @GetMapping(path="/reviews/review/{reviewId}")
    public Review getReviewsByReviewId(@PathVariable int reviewId){
        Review userReviews = reviews.getReviewByReviewId(reviewId);
        return userReviews;
    }











}
