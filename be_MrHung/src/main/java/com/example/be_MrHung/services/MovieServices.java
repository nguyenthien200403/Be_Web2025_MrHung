package com.example.be_MrHung.services;

import com.example.be_MrHung.models.Movie;
import com.example.be_MrHung.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
    public Optional<Movie> findById(Integer movie_id) {
        return movieRepository.findById(movie_id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
