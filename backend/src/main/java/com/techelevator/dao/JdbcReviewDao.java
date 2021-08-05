package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcReviewDao implements ReviewDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcReviewDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getAllReviewsByTargetId(long targetId, boolean beer) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews r JOIN review_of ro ON r.review_id = ro.review_id " +
                "WHERE ";
        if (beer){
            sql += "ro.beer_id = ?;";
        }else{
            sql += "ro.brewery_id = ?;";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, targetId);
        while(result.next()){
            Review review = mapRowSetToReview(result);
            reviews.add(review);
        }
        return reviews;
    }




    @Override
    public long createReview(Review r) {
        String sql = "INSERT INTO reviews (reviewer_name, review_text, review_stars, review_type, user_id) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING review_id;";
        long newId = jdbcTemplate.queryForObject(sql, Long.class, r.getReviewName(), r.getText(), r.getStarCount(),
                r.getType(), r.getUserId());
        return newId;
    }
    @Override
    public Review getReviewByReviewId(int reviewId) {
        String sql = "SELECT * FROM reviews WHERE review_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, reviewId);
        if (result.next()){
            return mapRowSetToReview(result);
        }
        return null;
    }
    @Override
    public void updateReview(Review r) {
        String sql = "UPDATE reviews SET reviewer_name = ?, review_text = ?, " +
                "review_stars = ?, review_type = ?, user_id = ? " +
                "WHERE review_id = ?;";
        jdbcTemplate.update(sql, r.getReviewName(), r.getText(), r.getStarCount(), r.getType(),
                r.getUserId(), r.getId());
    }

    @Override
    public void deleteReview(int reviewId) {
        String sql = "DELETE * FROM reviews WHERE review_id = ?;";
        jdbcTemplate.update(sql, reviewId);
    }

    @Override
    public List<Review> getAllReviewsByUserId(int userId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        while(result.next()){
            reviews.add(mapRowSetToReview(result));
        }
        return reviews;
    }

    @Override
    public int deleteReviews(int userId) {
        String sql = "DELETE * FROM reviews WHERE userId = ?;";
        int count = jdbcTemplate.update(sql, userId);
        return count;
    }

    private Review mapRowSetToReview(SqlRowSet rs){
        Review r = new Review();
        r.setId(rs.getLong("review_id"));
        r.setReviewName(rs.getString("reviewer_name"));
        r.setText(rs.getString("review_text"));
        r.setStarCount(rs.getInt("review_stars"));
        r.setType(rs.getString("review_type"));
        r.setUserId(rs.getLong("user_id"));
        return r;
    }
}