package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsApplication {
	public static void main(String[] args) {
//		ConfigurableApplicationContext context1 = SpringApplication.run(SpringBasicsApplication.class, args);
//		NoteService service = context1.getBean(NoteService.class);
//		System.out.println(service);
		SpringApplication.run(SpringBasicsApplication.class, args);
	}
}
