package com.tricket.trainTicket.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Registration {
	private User user;
	private Ticket ticket;
	private Seat seat;
	
	@JsonIgnore
    private static List<Registration> registrationList = new ArrayList<>();
	
	public Registration(User user, Ticket ticket, Seat seat) {
		super();
		this.user = user;
		this.ticket = ticket;
		this.seat = seat;
	}
	public Registration() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	@JsonIgnore
	public void addRegitration(Registration regis) {
		registrationList.add(regis);
	}
	@JsonIgnore
	public List<Registration>  getRegitration() {
		return registrationList;
	}
	@JsonIgnore
	public Registration  getRegitrationByid(long i) {
		 for (Registration registration : registrationList) {
		        if (registration.getUser().getId() == i) {
		            
		            return registration;
		        }
		    }
		    return null;
	}
	
	
	@Override
	public String toString() {
		return "Registration [user=" + user + ", ticket=" + ticket + ", seat=" + seat + "]";
	}
	public boolean removeUserFromTrain(long userId) {
		  for (Registration registration : registrationList) {
		        if (registration.getUser().getId() == userId) {
		            registrationList.remove(registration);
		            return true;
		        }
		    }
		    return false;
	}
	
	

}
