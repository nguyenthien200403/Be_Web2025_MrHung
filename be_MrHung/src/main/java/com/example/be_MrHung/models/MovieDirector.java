package com.example.be_MrHung.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "movie_directors")
public class MovieDirector {

    @EmbeddedId
    private MovieDirectorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("directorId")
    @JoinColumn(name = "director_id")
    private Director director;

    // Constructors, getters, setters
    public MovieDirector() {}

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}

@Embeddable
class MovieDirectorId implements Serializable {
    private Long movieId;
    private Long directorId;
}