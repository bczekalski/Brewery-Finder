package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;



public interface ReviewDao {


    List<Review> getAllReviewsByTargetId(long targetId, boolean beer);

    long createReview(Review newReview);
    Review getReviewByReviewId(int reviewId);
    void updateReview(Review review);
    void deleteReview(int reviewId);
    List<Review> getAllReviewsByUserId(int userId);


    int deleteReviews(int userId);
}
