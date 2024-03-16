package com.tricket.trainTicket.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ticket {

	private Long id;
    private String fromLocation;
    private String toLocation;
    private Long pricePaid;
    @JsonIgnore
    private  static List<Ticket> ticketList = new ArrayList<>();

	public Ticket(Long id, String fromLocation, String toLocation, Long pricePaid) {
		super();
		this.id = id;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.pricePaid = (long) 20;
	}
	public Ticket() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public Long getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(Long pricePaid) {
		this.pricePaid = pricePaid;
	}


    @JsonIgnore
    public void addTicket(Ticket ticket) {
    	ticketList.add(ticket);
    }

    @JsonIgnore
    public Ticket getTicket(int i) {
        return ticketList.get(i);
    }

    @JsonIgnore
    public  static List<Ticket> getAllTicket() {
        return ticketList;
    }

	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", pricePaid="
				+ pricePaid + "]";
	}

    

}
