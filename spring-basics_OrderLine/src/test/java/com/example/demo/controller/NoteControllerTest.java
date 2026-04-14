package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Order1;
import com.example.demo.service.NoteService;

class NoteControllerTest {
	@InjectMocks
	NoteController noteController;
	@Mock
	NoteService noteService;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetOrderById() {
		Order1 order1 = new Order1();
		when(noteService.getOrderById(1)).thenReturn(Optional.of(order1));
		Optional<Order1> result = noteController.getOrderById(1);
		assertTrue(result.isPresent());
	}

	@Test
	void testGetOrder() {
		Iterable<Order1> orders1 = new ArrayList<>();
		when(noteService.getOrder()).thenReturn(orders1);
		Iterable<Order1> result = noteController.getOrder();
		assertNotNull(result);
	}

	@Test
	void testCreateOrder() throws IOException {
		Order1 order1 = new Order1();
		when(noteService.addOrder(order1)).thenReturn(1);
		Integer result = noteController.createOrder(order1);
		assertNotNull(result);
		assertEquals(1, result);
	}

	void testDeleteById() {
		noteController.deleteOrderById(1);
		verify(noteService).deleteOrderById(1);
	}
}