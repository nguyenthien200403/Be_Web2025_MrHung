package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    List<Showtime> findByMovieMovieId(Integer movieId);
    List<Showtime> findByScreenCinemaCinemaId(Integer cinemaId);
    List<Showtime> findByStartTimeBetween(Date startDate, Date endDate);
}