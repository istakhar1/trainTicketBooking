package com.tricket.trainTicket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tricket.trainTicket.model.Ticket;

@RestController
public class TicketController {
	//Create API where you can submit a purchase for a ticket. Details included in the receipt are:
//	From, To, User , price paid.
	
	@GetMapping("/getTicket")
	public Ticket getTickets() {
		
		Ticket obj = new Ticket();
		obj.setId((long) 1);
		obj.setFromLocation("Dumka");
		obj.setToLocation("Ranchi");
		obj.setPricePaid((long) 500);

		return obj;
	}

}
