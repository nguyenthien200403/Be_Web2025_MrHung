package com.example.be_MrHung.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "movie_genres")
public class MovieGenre {

    @EmbeddedId
    private MovieGenreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    private Genre genre;

    // Constructors, getters, setters
    public MovieGenre() {}

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

@Embeddable
class MovieGenreId implements Serializable {
    private Long movieId;
    private Long genreId;

    // Default constructor
    public MovieGenreId() {}


}