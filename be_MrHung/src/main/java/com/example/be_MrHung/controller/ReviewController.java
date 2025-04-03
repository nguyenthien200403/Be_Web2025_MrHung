package com.example.be_MrHung.controller;

import com.example.be_MrHung.models.Review;
import com.example.be_MrHung.models.User;
import com.example.be_MrHung.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/listReview")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/movie/{movieId}")
    public Map<String, Object> getMovieReviews(@PathVariable Integer movieId) {
        return reviewService.getMovieReviewStats(movieId);
    }
}
