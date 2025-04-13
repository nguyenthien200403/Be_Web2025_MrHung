package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "booking_services")
@Data
public class BookingService {
    @EmbeddedId
    private BookingServiceId id;

    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(nullable = false)
    private Integer quantity = 1;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;
}

@Embeddable
@Data
class BookingServiceId implements Serializable {
    private Integer bookingId;
    private Integer serviceId;
}