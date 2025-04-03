package com.example.be_MrHung.controller;

import com.example.be_MrHung.models.Movie;
import com.example.be_MrHung.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class MoiveController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/listMovie")
    public List<Movie> getAllMovies() {
        return movieServices.getAllMovies();
    }

    @GetMapping("/findMovie/")
    public Optional<Movie> findMovieById(@RequestParam int movie_id) {
        return movieServices.findById(movie_id);
    }


}
