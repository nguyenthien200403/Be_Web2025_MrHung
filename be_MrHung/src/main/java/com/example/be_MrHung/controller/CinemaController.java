package com.example.be_MrHung.controller;

import com.example.be_MrHung.models.Cinema;
import com.example.be_MrHung.models.Movie;
import com.example.be_MrHung.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/listCinema")
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/findCinema/")
    public Optional<Cinema> findCinema(@RequestParam int cinema_id) {
        return cinemaService.getCinemaById(cinema_id);
    }

    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.createCinema(cinema);
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable("id") Integer id) {
        cinemaService.deleteCinema(id);
    }
}
