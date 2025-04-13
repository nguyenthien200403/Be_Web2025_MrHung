package com.example.be_MrHung.controller;

import com.example.be_MrHung.models.Movie;
import com.example.be_MrHung.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/currently-showing")
    public List<Movie> getCurrentlyShowingMovies() {
        return movieService.getCurrentlyShowingMovies();
    }

    @GetMapping("/upcoming")
    public List<Movie> getUpcomingMovies() {
        return movieService.getUpcomingMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }
}