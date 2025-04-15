package com.example.be_MrHung.services;

import com.example.be_MrHung.dto.MovieDTO;
import com.example.be_MrHung.dto.MovieDetailDTO;


import java.util.List;

public interface MovieService {
    List<MovieDTO> getAllMovies();
    List<MovieDTO> getNowShowingMovies();
    List<MovieDTO> getComingSoonMovies();
    MovieDetailDTO getMovieDetails(Long movieId);
}
