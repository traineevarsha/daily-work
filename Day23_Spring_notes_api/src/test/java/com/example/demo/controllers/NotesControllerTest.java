package com.example.demo.controllers;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.services.NotesService;

class NotesControllerTest {
	@InjectMocks
	NotesController notesController;
	@Mock
	NotesService notesService;

//	@Test
////	void getNotes() {
////		Iterable<Note> notes = new ArrayList<>();
////		when(notesService.getNotes()).thenReturn(notes);
////		Iterable<Note> result = notesController.getNotes();
////		assertNotNull(result);
////	}

}
