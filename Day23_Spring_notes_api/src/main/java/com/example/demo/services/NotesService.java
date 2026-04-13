package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Note;
import com.example.demo.repository.NotesRepository;

@Service
public class NotesService {

	@Autowired
	NotesRepository notesRepository;

	public Iterable<Note> getNotes() {
		return notesRepository.findAll();
	}

	public Note createNote(Note note) {
		return notesRepository.save(note);
	}

}