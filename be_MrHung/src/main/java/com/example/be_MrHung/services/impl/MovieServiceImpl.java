package com.example.be_MrHung.services.impl;

import com.example.be_MrHung.dto.*;

import com.example.be_MrHung.exception.ResourceNotFoundException;
import com.example.be_MrHung.models.*;
import com.example.be_MrHung.repositorys.*;
import com.example.be_MrHung.services.MovieService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;
    private final MovieActorRepository movieActorRepository;
    private final MovieDirectorRepository movieDirectorRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper,
                            MovieActorRepository movieActorRepository, MovieDirectorRepository movieDirectorRepository,
                            MovieGenreRepository movieGenreRepository, ShowtimeRepository showtimeRepository) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
        this.movieActorRepository = movieActorRepository;
        this.movieDirectorRepository = movieDirectorRepository;
        this.movieGenreRepository = movieGenreRepository;
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getNowShowingMovies() {
        List<Movie> movies = movieRepository.findByIsNowShowing(true);
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getComingSoonMovies() {
        List<Movie> movies = movieRepository.findByIsNowShowing(false);
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDetailDTO getMovieDetails(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));

        MovieDetailDTO movieDetailDTO = modelMapper.map(movie, MovieDetailDTO.class);

        // Set genres
        List<MovieGenre> movieGenres = movieGenreRepository.findByMovieId(movieId);
        List<GenreDTO> genreDTOs = movieGenres.stream()
                .map(mg -> modelMapper.map(mg.getGenre(), GenreDTO.class))
                .collect(Collectors.toList());
        movieDetailDTO.setGenres(genreDTOs);

        // Set actors
        List<MovieActor> movieActors = movieActorRepository.findByMovieId(movieId);
        List<ActorDTO> actorDTOs = movieActors.stream()
                .map(ma -> {
                    ActorDTO actorDTO = modelMapper.map(ma.getActor(), ActorDTO.class);
                    actorDTO.setCharacterName(ma.getCharacterName());
                    actorDTO.setLead(ma.getIsLead());
                    return actorDTO;
                })
                .collect(Collectors.toList());
        movieDetailDTO.setActors(actorDTOs);

        // Set directors
        List<MovieDirector> movieDirectors = movieDirectorRepository.findByMovieId(movieId);
        List<DirectorDTO> directorDTOs = movieDirectors.stream()
                .map(md -> modelMapper.map(md.getDirector(), DirectorDTO.class))
                .collect(Collectors.toList());
        movieDetailDTO.setDirectors(directorDTOs);

        // Set showtimes
        List<Showtime> showtimes = showtimeRepository.findByMovieId(movieId);
        List<ShowtimeDTO> showtimeDTOs = showtimes.stream()
                .map(st -> modelMapper.map(st, ShowtimeDTO.class))
                .collect(Collectors.toList());
        movieDetailDTO.setShowtimes(showtimeDTOs);

        return movieDetailDTO;
    }
}
