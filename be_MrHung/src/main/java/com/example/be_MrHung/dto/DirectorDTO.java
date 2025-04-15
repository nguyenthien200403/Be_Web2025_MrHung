package com.example.be_MrHung.dto;

import java.util.Date;

public class DirectorDTO {
    private Integer id;
    private String name;
    private String bio;
    private Date dateOfBirth;
    private String nationality;
    private Date createdAt;

    public DirectorDTO() {
    }

    public DirectorDTO(Integer id, String name, String bio, Date dateOfBirth, String nationality, Date createdAt) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
