package com.example.be_MrHung.repository;

import com.example.be_MrHung.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT COUNT(r), COALESCE(AVG(r.rating), 0) FROM Review r WHERE r.movie.movieId = :movieId")
    Optional<Object[]> getReviewStatsByMovieId(@Param("movieId") Integer movieId);
}
