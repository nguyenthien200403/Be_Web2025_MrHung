package com.example.be_MrHung.services;

import com.example.be_MrHung.models.Movie;
import com.example.be_MrHung.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    //Current Movies
    public List<Movie> getCurrentlyShowingMovies() {
        return movieRepository.findByIsNowShowingTrue();
    }

    //Upcoming Movies
    public List<Movie> getUpcomingMovies() {
        return movieRepository.findUpcomingMovies();
    }

    //Detail Movie
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }
}