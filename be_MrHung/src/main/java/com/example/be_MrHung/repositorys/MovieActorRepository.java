package com.example.be_MrHung.repositorys;

import com.example.be_MrHung.models.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {
    @Query("SELECT ma FROM MovieActor ma WHERE ma.movie.id = :movieId")
    List<MovieActor> findByMovieId(@Param("movieId") Long movieId);

}
