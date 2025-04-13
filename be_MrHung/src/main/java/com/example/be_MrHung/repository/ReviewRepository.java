package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);
    List<Review> findByUserId(Long userId);
    List<Review> findByMovieIdAndUserId(Long movieId, Long userId);
    List<Review> findByRating(Integer rating);
    List<Review> findByRatingBetween(Integer minRating, Integer maxRating);
}