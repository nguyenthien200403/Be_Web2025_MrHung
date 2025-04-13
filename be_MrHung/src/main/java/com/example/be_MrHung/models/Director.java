package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "directors")
@Data
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer directorId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(length = 50)
    private String nationality;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @ManyToMany(mappedBy = "directors")
    private Set<Movie> movies;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}