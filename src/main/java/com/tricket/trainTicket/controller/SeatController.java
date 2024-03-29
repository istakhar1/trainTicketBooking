package com.tricket.trainTicket.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tricket.trainTicket.model.Registration;
import com.tricket.trainTicket.model.Seat;

@RestController
public class SeatController {
    @PutMapping("/modifyUserSeat/{userId}")
    public String modifyUserSeat(@RequestBody Seat request,@PathVariable("userId") long userId) {
        // Assuming SeatModificationRequest is a DTO class containing userId and newSeatId fields
    	
    	if(!(request.getSection().equalsIgnoreCase("A") || request.getSection().equalsIgnoreCase("B"))) {
    		return "Invalid Seat Section !!!";
    	}
    	if(request.getId()>10) {
    		return "Invalid Seat Number !!!";
    	}
    	Registration userDetails = new Registration();
      
		// chec seat is availabe or not 
    	boolean isSeatAvailabe = userDetails.checkSeat(request);
    	
        // Assuming you have a method to modify a user's seat using the userId and newSeatId
		userDetails = userDetails.getRegitrationByid((int)userId);
		long newSeatId =request.getId();
        if (isSeatAvailabe && userDetails!=null) {
        	userDetails.setSeat(request);
            return "User with ID " + userId + " has been moved to seat " + newSeatId + ".";
        } else {
            return "Failed to modify user's seat. User with ID " + userId + " or seat " + newSeatId + " not found.";
        }
    }

}
