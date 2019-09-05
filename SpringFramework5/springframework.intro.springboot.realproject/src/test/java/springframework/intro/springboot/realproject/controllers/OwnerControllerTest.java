package springframework.intro.springboot.realproject.controllers;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashPrintServiceAttributeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import springframework.intro.springboot.realproject.models.Owner;
import springframework.intro.springboot.realproject.services.OwnerService;


@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

	// create a mock of Owner service
	@Mock
	OwnerService ownerService;
	
	// inject mock in the controller
	@InjectMocks
	OwnerController ownerController;
	
	// allow us to test Spring endpoints of a controller: status, response, etc...
	MockMvc mockMvc;

	Set<Owner> owners;
	
	@BeforeEach
	public void setUp() {
		
		owners = new HashSet<>();
		
		// create set of data
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());
		
		
		// initialize a mock environment for the owner controller
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
		
	}
	
	@Test
	public void listOwnersTest() throws Exception {
		
		// retrieve data from the service
		when(ownerService.findAll()).thenReturn(owners);
		
		
		// call the endpoint "/owners" and check if status is ok
		mockMvc.perform(get("/owners"))
				.andExpect(status().is(200))
				.andExpect(view().name("owners/owner"));
		
		
	}
	
	
	@Test
	public void findOwnersTest() throws Exception {
		
		mockMvc.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("notImplemented"));
		
		verifyZeroInteractions(ownerService);
		
	}
	
}
