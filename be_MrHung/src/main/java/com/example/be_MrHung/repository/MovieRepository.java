package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByIsNowShowing(Boolean isNowShowing);
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByGenresName(String genreName);
}