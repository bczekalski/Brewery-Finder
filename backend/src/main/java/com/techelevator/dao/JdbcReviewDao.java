package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getAllReviewsByTargetId(long targetId, String type) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE target_id = ? AND review_type = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, targetId, type);
        while(result.next()){
            Review review = mapRowSetToReview(result);
            reviews.add(review);
        }
        return reviews;
    }




    @Override
    public long createReview(Review r) {
        String sql = "INSERT INTO reviews (reviewer_name, review_title, review_text, review_stars, review_type, user_id, target_id, reviewee_name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING review_id;";
        long newId = jdbcTemplate.queryForObject(sql, Long.class, r.getName(), r.getTitle(), r.getText(),
                r.getStarCount(), r.getType(), r.getUserId(), r.getTargetId(), r.getTargetName());
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
        String sql = "UPDATE reviews SET reviewer_name = ?, review_title = ?, review_text = ?, " +
                "review_stars = ?, review_type = ?, user_id = ?, target_id = ?, reviewee_name = ? " +
                "WHERE review_id = ?;";
        jdbcTemplate.update(sql, r.getName(), r.getTitle(), r.getText(), r.getStarCount(),
                r.getType(), r.getUserId(), r.getTargetId(), r.getTargetName(), r.getId());
    }

    @Override
    public void deleteReview(int reviewId) {
        String sql = "DELETE * FROM reviews WHERE review_id = ?;";
        jdbcTemplate.update(sql, reviewId);
    }

    @Override
    public List<Review> getAllReviewsByUserId(long userId) {
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

    private Review mapRowSetToReview(SqlRowSet rs) {
        Review r = new Review();
        r.setId(rs.getLong("review_id"));
        r.setName(rs.getString("reviewer_name"));
        r.setTitle(rs.getString("review_title"));
        r.setText(rs.getString("review_text"));
        r.setStarCount(rs.getInt("review_stars"));
        r.setType(rs.getString("review_type"));
        r.setUserId(rs.getLong("user_id"));
        r.setTargetId(rs.getLong("target_id"));
        r.setTargetName(rs.getString("reviewee_name"));
        return r;
    }
}