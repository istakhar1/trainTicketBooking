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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tricket.trainTicket.model.Registration;
import com.tricket.trainTicket.model.Seat;

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
	        
	        

	        // Perform GET request to /getAllRegistration endpoint
	        mockMvc.perform(MockMvcRequestBuilders.get("/getAllRegistration")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP status OK
	                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(mockRegistrations.size())); // Expect the size of the response list to be the same as the mock registrations list
	    }


	    @Test
	    void testModifyUserSeatInvalidSection() throws Exception {
	        // Prepare mock request with invalid seat section
	    	Registration registration = new Registration();
	        Seat mockSeatRequest = new Seat("C", 1L);

	        // Perform PUT request to /modifyUserSeat/{userId} endpoint with invalid seat section
	        mockMvc.perform(MockMvcRequestBuilders.put("/modifyUserSeat/123")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(mockSeatRequest)))
	                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP status OK
	                .andExpect(MockMvcResultMatchers.content().string("Invalid Seat Section !!!")); // Expect invalid seat section message
	    }

	    @Test
	    void testModifyUserSeatInvalidNumber() throws Exception {
	        // Prepare mock request with invalid seat number
	    	Registration registration = new Registration();
	        Seat mockSeatRequest = new Seat("A", 15L); // Assuming the seat number is invalid

	        // Perform PUT request to /modifyUserSeat/{userId} endpoint with invalid seat number
	        mockMvc.perform(MockMvcRequestBuilders.put("/modifyUserSeat/123")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(mockSeatRequest)))
	                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP status OK
	                .andExpect(MockMvcResultMatchers.content().string("Invalid Seat Number !!!")); // Expect invalid seat number message
	    }


	    // Helper method to convert object to JSON string
	    private String asJsonString(Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
	@Test
	void contextLoads() {
	}

}
