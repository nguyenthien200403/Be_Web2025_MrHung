package com.example.be_MrHung.services;
import com.example.be_MrHung.models.Cinema;
import com.example.be_MrHung.repository.CinemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public List<Cinema> getCinemasByCity(String city) {
        return cinemaRepository.findByCity(city);
    }

    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElseThrow();
    }

    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Cinema updateCinema(Long id, Cinema cinemaDetails) {
        Cinema cinema = getCinemaById(id);
        cinema.setName(cinemaDetails.getName());
        cinema.setAddress(cinemaDetails.getAddress());
        cinema.setCity(cinemaDetails.getCity());
        cinema.setPhoneNumber(cinemaDetails.getPhoneNumber());
        cinema.setTotalScreens(cinemaDetails.getTotalScreens());
        cinema.onUpdate();
        return cinemaRepository.save(cinema);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}