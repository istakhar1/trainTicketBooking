package com.tricket.trainTicket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private static long nextId = 0; // static variable to keep track of the next available seat ID
    private Long id;
    private String section;
    @JsonIgnore
    private User user;

    // Constructor
    public Seat(String section, User user) {
        this.id = nextId++; // Assign a unique ID to each seat
        this.section = section;
        this.user = user;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void decrreementID() {
    	nextId--;
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
