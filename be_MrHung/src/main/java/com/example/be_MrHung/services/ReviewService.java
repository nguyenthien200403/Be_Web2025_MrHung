package com.example.be_MrHung.services;

import com.example.be_MrHung.models.Review;
import com.example.be_MrHung.models.User;
import com.example.be_MrHung.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Map<String, Object> getMovieReviewStats(Integer movieId) {
        Object[] stats = reviewRepository.getReviewStatsByMovieId(movieId).orElse(new Object[]{0L, 0.0});
        Map<String, Object> response = new HashMap<>();
        response.put("totalReviews", ((Number) stats[0]).intValue());
        response.put("averageRating", ((Number) stats[1]).doubleValue());
        return response;
    }
}
