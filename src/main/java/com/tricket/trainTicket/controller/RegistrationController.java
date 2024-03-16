package com.tricket.trainTicket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tricket.trainTicket.model.Registration;
import com.tricket.trainTicket.model.Seat;
import com.tricket.trainTicket.model.Ticket;
import com.tricket.trainTicket.model.User;

@RestController
public class RegistrationController {

	@PostMapping("/ticketRegistration")
	public Registration  registerTicket(@RequestBody Registration newregistation) {
		
		
		//user set krana hai
		User user = new User();
		List<User>  allUser= user.getAllUser();
		int newUserId = allUser.size()+1;
		user.setId((long) newUserId);
	    user.setFirstName(newregistation.getUser().getFirstName());
	    user.setLastName(newregistation.getUser().getLastName());
	    user.setEmail(newregistation.getUser().getEmail());
	    user.addUser(user);
	    newregistation.getUser().setId((long)newUserId);
	    
		//ticket seat karna h;
	    Ticket ticket = new Ticket();
	    List<Ticket> allTicket = ticket.getAllTicket();
	    int ticketId = allTicket.size()+1;
	    ticket.setId((long)ticketId);
	    ticket.setPricePaid(newregistation.getTicket().getPricePaid());
	    ticket.setFromLocation(newregistation.getTicket().getFromLocation());
	    ticket.setToLocation(newregistation.getTicket().getToLocation());
	    newregistation.getTicket().setId((long)ticketId);
	    ticket.addTicket(ticket);
		// seat set karna h;
	    
	   Seat newSeat = new Seat("A",user);
	   long id = newSeat.getId();
	   if(id>10) {
		   newSeat.decrreementID();
		   Seat newSeatB = new Seat("B",user);
		   newregistation.setSeat(newSeatB);
		   
	   }
	   else if (id<=20) {
		   newregistation.setSeat(newSeat);
	   }
	   
	   Registration reg = new Registration();
	   reg.addRegitration(newregistation);
	  
	   
		return newregistation;
	}

	@GetMapping("/getAllRegistration")
	public List<Registration> getAllRegistrationDetails(){
		Registration allreg = new Registration();
		List<Registration> allList = allreg.getRegitration();
		return allList;
	}
	@DeleteMapping("/removeUser/{userId}")
	    public String removeUserFromTrain(@PathVariable("userId") long userId) {
		   Registration trainService = new Registration();
	        // Assuming you have a method to remove a user from the train using the userId
	        boolean removed = trainService.removeUserFromTrain(userId);
	        if (removed) {
	            return "User with ID " + userId + " has been removed from the train.";
	        } else {
	            return "User with ID " + userId + " was not found on the train.";
	        }
	    }
}
