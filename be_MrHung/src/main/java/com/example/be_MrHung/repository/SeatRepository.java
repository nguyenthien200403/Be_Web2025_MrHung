package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByScreenScreenId(Integer screenId);
}