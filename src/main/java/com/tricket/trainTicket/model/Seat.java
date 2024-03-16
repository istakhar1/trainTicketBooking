package com.tricket.trainTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
 // static variable to keep track of the next available seat ID
    private Long id;
    private String section;
    @JsonIgnore
    private User user;

    // Constructor
    public Seat(String section, User user, Long id) {
        this.id = id; // Assign a unique ID to each seat
        this.section = section;
        this.user = user;
    }
    public Seat(String section,Long id) {
        this.id = id; // Assign a unique ID to each seat
        this.section = section;
    }

    public Seat() {
   
    }
    // Getters and setters
    
    public void setId(Long id) {
         this.id= id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setSection(String section) {
         this.section=section;
    }
    public String getSection() {
        return section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Seat [id=" + id + ", section=" + section + ", user=" + user + "]";
    }

    // Method to check if the seat is available

}
