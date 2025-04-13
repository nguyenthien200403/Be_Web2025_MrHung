package com.example.be_MrHung.controller;
import com.example.be_MrHung.models.Cinema;
import com.example.be_MrHung.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/city/{city}")
    public List<Cinema> getCinemasByCity(@PathVariable String city) {
        return cinemaService.getCinemasByCity(city);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable Long id) {
        Cinema cinema = cinemaService.getCinemaById(id);
        return ResponseEntity.ok(cinema);
    }

    @PostMapping
    public ResponseEntity<Cinema> createCinema(@RequestBody Cinema cinema) {
        Cinema createdCinema = cinemaService.createCinema(cinema);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCinema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable Long id, @RequestBody Cinema cinemaDetails) {
        Cinema updatedCinema = cinemaService.updateCinema(id, cinemaDetails);
        return ResponseEntity.ok(updatedCinema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
        return ResponseEntity.noContent().build();
    }
}