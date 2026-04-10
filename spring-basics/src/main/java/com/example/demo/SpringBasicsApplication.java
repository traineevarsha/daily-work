package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.controller.NoteController;

@SpringBootApplication
public class SpringBasicsApplication {
	public static void main(String[] args) {
		// ConfigurableApplicationContext context1 =
		// SpringApplication.run(SpringBasicsApplication.class, args);
		// NoteService service = context1.getBean(NoteService.class);
		// System.out.println(service);
		ConfigurableApplicationContext context = SpringApplication.run(SpringBasicsApplication.class, args);
		NoteController controller = context.getBean(NoteController.class);
		System.out.println(controller);
	}

	@Bean
	NoteController noteController() {
		return new NoteController();
	}

}
