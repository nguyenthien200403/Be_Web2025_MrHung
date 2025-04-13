package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Find movies that are currently showing
    List<Movie> findByIsNowShowingTrue();

    // Find upcoming movies (release date after today and not yet showing)
    @Query("SELECT m FROM Movie m WHERE m.releaseDate > CURRENT_DATE AND m.isNowShowing = false")
    List<Movie> findUpcomingMovies();

}