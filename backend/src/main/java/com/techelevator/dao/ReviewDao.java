package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> getAllReviewsByTargetId(long targetId, String type);

    long createReview(Review newReview);

    Review getReviewByReviewId(int reviewId);

    void updateReview(Review review);

    void deleteReview(int reviewId);

    List<Review> getAllReviewsByUserId(long userId);

    //List<Beer> topRatedBeers();

    int deleteReviews(int userId);

    long createBeerReview(Review r);
}
