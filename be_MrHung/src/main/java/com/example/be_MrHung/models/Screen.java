package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "screens")
@Data
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @Column(name = "screen_name", nullable = false, length = 50)
    private String name;

    @Column(name = "screen_type", length = 50)
    private String type;

    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "screen")
    private Set<Seat> seats;

    @OneToMany(mappedBy = "screen")
    private Set<Showtime> showtimes;
}