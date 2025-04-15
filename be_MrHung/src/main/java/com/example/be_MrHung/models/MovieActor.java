package com.example.be_MrHung.models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "movie_actors")
public class MovieActor {

    @EmbeddedId
    private MovieActorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "is_lead")
    private boolean isLead;

    // Constructors, getters, setters
    public MovieActor() {}

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public boolean getIsLead() {
        return isLead;
    }

    public void setIsLead(boolean isLead) {
        this.isLead = isLead;
    }
}

@Embeddable
class MovieActorId implements Serializable {
    private Long movieId;
    private Long actorId;
    // Constructors, equals, hashCode
}