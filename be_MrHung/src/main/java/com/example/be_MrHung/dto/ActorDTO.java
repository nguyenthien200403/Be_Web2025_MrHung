package com.example.be_MrHung.dto;

public class ActorDTO {
    private Long id;
    private String name;
    private String bio;
    private String dateOfBirth;
    private String nationality;
    private String characterName;  // Thêm trường này để lưu tên nhân vật diễn viên đóng
    private boolean isLead;       // Thêm trường này để xác định có phải vai chính không

    // Constructors
    public ActorDTO() {
    }

    public ActorDTO(Long id, String name, String bio, String dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public boolean isLead() {
        return isLead;
    }

    public void setLead(boolean lead) {
        isLead = lead;
    }

    // Có thể thêm toString() nếu cần
    @Override
    public String toString() {
        return "ActorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characterName='" + characterName + '\'' +
                ", isLead=" + isLead +
                '}';
    }
}
