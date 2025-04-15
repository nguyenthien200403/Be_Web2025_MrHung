package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "directors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(length = 50)
    private String nationality;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
}
