package com.tricket.trainTicket.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tricket.trainTicket.model.Registration;
import com.tricket.trainTicket.model.Ticket;
import com.tricket.trainTicket.model.User;

@RestController
public class UserController {

	@PostMapping("/userRegistration")
	public User createUser(@RequestBody User newUser) {
		
		User user = new User();
		List<User>  allUser= user.getAllUser();
		int id = allUser.size()+1;
		user.setId((long) id);
	    user.setFirstName(newUser.getFirstName());
	    user.setLastName(newUser.getLastName());
	    user.setEmail(newUser.getEmail());
	    user.addUser(user);
	    System.out.println("array size"+id);
	    User newUserFromDB= user.getUser(id-1);
		return newUserFromDB;
	}
	
	@GetMapping("/getUserRecipt")
	public Registration getUserRecipt(@RequestParam("userId") long userId) {
		
		Registration userDetails = new Registration();
		userDetails = userDetails.getRegitrationByid(userId);
	
		return userDetails;
	}
}
