package com.tricket.trainTicket;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tricket.trainTicket.model.Registration;

@SpringBootTest
@AutoConfigureMockMvc
class TrainTicketApplicationTests {
	 @Autowired
	    private MockMvc mockMvc;
	  @MockBean
	    private List<Registration> registrationList;
	 
	  @Test
	    void testRegisterTicket() throws Exception {
	        // Prepare mock data
	        Registration newRegistration = new Registration();
	        // Mocking the behavior of adding a new registration
	        mockMvc.perform(MockMvcRequestBuilders.post("/ticketRegistration")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"user\": {\"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john@example.com\"}, "
	                        + "\"ticket\": {\"fromLocation\": \"Location A\", \"toLocation\": \"Location B\", \"pricePaid\": 10}}"))
	                .andExpect(MockMvcResultMatchers.status().isOk()); // Expect HTTP status OK
	    }
	    @Test
	    void testGetAllRegistrationDetails() throws Exception {
	        // Prepare mock data
	    	Registration registration = new Registration();
	        List<Registration> mockRegistrations = new ArrayList<>();
	        // Add some mock registrations
	        mockRegistrations.add(new Registration());
	        mockRegistrations.add(new Registration());
	        
	        
			// Mock the behavior of the registration object
//	        when(registration.getRegitration()).thenReturn(mockRegistrations);

	        // Perform GET request to /getAllRegistration endpoint
	        mockMvc.perform(MockMvcRequestBuilders.get("/getAllRegistration")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP status OK
	                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(mockRegistrations.size())); // Expect the size of the response list to be the same as the mock registrations list
	    }
	
	@Test
	void contextLoads() {
	}

}
