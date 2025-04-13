package com.example.be_MrHung.repository;


import com.example.be_MrHung.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByNameContainingIgnoreCase(String name);
    List<Actor> findByNationality(String nationality);
}