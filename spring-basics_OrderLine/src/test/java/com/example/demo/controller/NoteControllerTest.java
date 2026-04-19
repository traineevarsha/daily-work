package com.example.demo.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Order1;
import com.example.demo.entity.OrderLine;
import com.example.demo.repository.Order1Repository;
import com.example.demo.service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private NoteService noteService;
	@MockBean
	private Order1Repository order1Repository;

	@Autowired
	private ObjectMapper objectMapper;

	private Order1 order1;
	private OrderLine orderLine;

	@BeforeEach
	void setUp() {
		orderLine = new OrderLine();
		orderLine.setId(1);
		orderLine.setItem("Laptop");
		orderLine.setPrice(999.99f);
		orderLine.setQuantity(1);
		order1 = new Order1();
		order1.setId(1);
		order1.setOrderLines(Arrays.asList(orderLine));
		orderLine.setOrder1(order1);
	}
	@Test
	void testSuccesfulGetAllOrders() throws Exception {
		when(noteService.getOrder()).thenReturn(List.of(order1));
		mockMvc.perform(get("/order"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].id").value(1));
	}
	@Test
	void testsuccessfulgetOrderById() throws Exception {
		when(noteService.getOrderById(1)).thenReturn(Optional.of(order1));
		mockMvc.perform(get("/order/1")
				.contentType(MediaType.APPLICATION_JSON))//tels server that we are sending json format data
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.orderLines[0].item").value("Laptop"))
				.andExpect(jsonPath("$.orderLines[0].price").value(999.99f))
				.andExpect(jsonPath("$.orderLines[0].quantity").value(1));
		verify(noteService, times(1)).getOrderById(1);
	}
	@Test
	void testGetOrderByIdForNonExsistentId() throws Exception {
		when(noteService.getOrderById(999)).thenReturn(Optional.empty());
		mockMvc.perform(get("/order/999")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
		verify(noteService,times(1)).getOrderById(999);
	}
	@Test
	void testCreateOrderForSuccessfulCreation() throws Exception {
		when(noteService.addOrder(any(Order1.class))).thenReturn(1);
		mockMvc.perform(post("/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(order1)))
				.andExpect(status().isCreated())
				.andExpect(content().string("1"));
		verify(noteService).addOrder(any(Order1.class));
	}
	@Test
	void testCreateOrderForMissingOrderLines() throws Exception {
		Order1 invalidOrder1 = new Order1();
		invalidOrder1.setOrderLines(null);
		mockMvc.perform(post("/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(invalidOrder1)))
				.andExpect(status().isBadRequest());
		verify(noteService,never()).addOrder(any(Order1.class));
		
	}
	   @Test
	    void testDeleteOrderByIdForSuccessfulDeletion() throws Exception {
	        mockMvc.perform(delete("/order/1"))
	                .andExpect(status().isNoContent());
	        verify(noteService, times(1)).deleteOrderById(1);
	    }
	   @Test
	    void testDeleteOrderByIdForNonExistentId() throws Exception {
	        doNothing().when(noteService).deleteOrderById(999);
	        mockMvc.perform(delete("/order/999")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNoContent());
	        verify(noteService, times(1)).deleteOrderById(999);
	    }
	
}