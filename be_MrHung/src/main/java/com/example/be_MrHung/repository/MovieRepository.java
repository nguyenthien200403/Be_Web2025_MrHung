package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
