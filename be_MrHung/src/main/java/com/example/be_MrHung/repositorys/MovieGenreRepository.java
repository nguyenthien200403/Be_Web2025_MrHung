package com.example.be_MrHung.repositorys;

import com.example.be_MrHung.models.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {
    // Tìm tất cả thể loại của một bộ phim
    @Query("SELECT mg FROM MovieGenre mg WHERE mg.movie.id = :movieId")
    List<MovieGenre> findByMovieId(@Param("movieId") Long movieId);
}
