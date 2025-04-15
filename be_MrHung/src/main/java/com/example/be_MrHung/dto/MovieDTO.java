package com.example.be_MrHung.dto;



import java.util.Date;
import java.util.Set;


public class MovieDTO {
    private Long movieId;
    private String title;
    private String description;
    private Integer duration;
    private Date releaseDate;
    private String rating;
    private String posterUrl;
    private String trailerUrl;
    private Boolean isNowShowing;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Boolean getNowShowing() {
        return isNowShowing;
    }

    public void setNowShowing(Boolean nowShowing) {
        isNowShowing = nowShowing;
    }
}
