package com.example.be_MrHung.services;


import com.example.be_MrHung.models.Booking;
import com.example.be_MrHung.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findByUserUserId(userId);
    }

    public List<Booking> getBookingsByShowtimeId(Integer showtimeId) {
        return bookingRepository.findByShowtimeShowtimeId(showtimeId);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Integer id) {
        bookingRepository.deleteById(id);
    }
}