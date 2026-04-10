package com.example.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NoteService {
	public NoteService() {
		System.out.println("Service initial");
	}
}
