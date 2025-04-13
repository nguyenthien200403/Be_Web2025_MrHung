package com.example.be_MrHung.services;


import com.example.be_MrHung.models.Review;
import com.example.be_MrHung.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public List<Review> getReviewsByMovieAndUser(Long movieId, Long userId) {
        return reviewRepository.findByMovieIdAndUserId(movieId, userId);
    }

    public List<Review> getReviewsByRating(Integer rating) {
        return reviewRepository.findByRating(rating);
    }

    public List<Review> getReviewsByRatingRange(Integer minRating, Integer maxRating) {
        return reviewRepository.findByRatingBetween(minRating, maxRating);
    }

//    public Double getAverageRatingByMovieId(Long movieId) {
//        return reviewRepository.findByMovieId(movieId).stream()
//                .mapToInt(Review::getRating)
//                .average()
//                .orElse(0.0);
//    }
}