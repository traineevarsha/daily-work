package com.example.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order1;

@Service
@Scope("prototype")
public class NoteService {
	public Order1 getOrder() {
		Order1 order = new Order1();
		order.setItem("Laptop");
		order.setPrice(100f);
		return order;

	}

	public Integer addOrder(Order1 order1) {
		return 1;
	}
}
