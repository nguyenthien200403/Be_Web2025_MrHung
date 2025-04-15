package com.example.be_MrHung.repositorys;

import com.example.be_MrHung.models.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query("SELECT s FROM Showtime s WHERE s.movie.id = :movieId")
    List<Showtime> findByMovieId(@Param("movieId") Long movieId);
}
