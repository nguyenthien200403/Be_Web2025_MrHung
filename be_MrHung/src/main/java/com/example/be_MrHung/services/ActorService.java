package com.example.be_MrHung.services;


import com.example.be_MrHung.models.Actor;
import com.example.be_MrHung.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<Actor> getActorById(Integer id) {
        return actorRepository.findById(id);
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public void deleteActor(Integer id) {
        actorRepository.deleteById(id);
    }

    public List<Actor> searchActors(String name) {
        return actorRepository.findByNameContainingIgnoreCase(name);
    }
}