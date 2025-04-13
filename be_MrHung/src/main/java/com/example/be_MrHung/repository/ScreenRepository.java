package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    List<Screen> findByCinemaCinemaId(Integer cinemaId);
}