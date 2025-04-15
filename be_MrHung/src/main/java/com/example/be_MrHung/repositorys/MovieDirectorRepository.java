package com.example.be_MrHung.repositorys;

import com.example.be_MrHung.models.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Long> {
    // Tìm tất cả đạo diễn của một bộ phim
    @Query("SELECT md FROM MovieDirector md WHERE md.movie.id = :movieId")
    List<MovieDirector> findByMovieId(@Param("movieId") Long movieId);
}
