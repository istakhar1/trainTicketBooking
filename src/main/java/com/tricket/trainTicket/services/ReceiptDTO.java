package com.tricket.trainTicket.services;

import com.tricket.trainTicket.model.User;

public class ReceiptDTO {
	
	private String From;
	 private String To;
	 private Integer userId;
	private Long pricepaid;
	public ReceiptDTO(String from, String to, Integer user, Long pricepaid) {
		super();
		From = from;
		To = to;
		this.userId = user;
		this.pricepaid = pricepaid;
	}
	public ReceiptDTO() {
		super();
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public Integer getUser() {
		return userId;
	}
	public void setUser(Integer user) {
		this.userId = user;
	}
	public Long getPricepaid() {
		return pricepaid;
	}
	public void setPricepaid(Long pricepaid) {
		this.pricepaid = pricepaid;
	}
	@Override
	public String toString() {
		return "ReceiptDTO [From=" + From + ", To=" + To + ", user=" + userId + ", pricepaid=" + pricepaid + "]";
	}
	
}
