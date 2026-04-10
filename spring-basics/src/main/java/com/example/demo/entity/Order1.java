package com.example.demo.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order1 {
	private int id;
	@NotBlank
	private String item;
	@Min(value = 1)
	private float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
