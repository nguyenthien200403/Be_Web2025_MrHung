package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "seats")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(name = "seat_row", nullable = false, length = 1)
    private String row;

    @Column(name = "seat_number", nullable = false)
    private Integer number;

    @Column(name = "seat_type", length = 20)
    private String type = "Standard";

    @OneToMany(mappedBy = "seat")
    private Set<Ticket> tickets;
}