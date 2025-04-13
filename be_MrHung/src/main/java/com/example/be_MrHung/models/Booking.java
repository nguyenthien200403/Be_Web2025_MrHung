package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booking_time")
    private Date bookingTime;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @OneToMany(mappedBy = "booking")
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "booking")
    private Set<BookingService> bookingServices;

    @OneToOne(mappedBy = "booking")
    private Payment payment;

    @PrePersist
    protected void onCreate() {
        bookingTime = new Date();
    }
}