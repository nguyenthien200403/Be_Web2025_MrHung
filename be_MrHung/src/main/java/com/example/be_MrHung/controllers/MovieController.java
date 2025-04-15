package com.example.be_MrHung.controllers;


import com.example.be_MrHung.dto.MovieDTO;
import com.example.be_MrHung.dto.MovieDetailDTO;
import com.example.be_MrHung.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/now-showing")
    public ResponseEntity<List<MovieDTO>> getNowShowingMovies() {
        List<MovieDTO> movies = movieService.getNowShowingMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/coming-soon")
    public ResponseEntity<List<MovieDTO>> getComingSoonMovies() {
        List<MovieDTO> movies = movieService.getComingSoonMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> getMovieDetails(@PathVariable Long id) {
        MovieDetailDTO movieDetail = movieService.getMovieDetails(id);
        return ResponseEntity.ok(movieDetail);
    }
}
