package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.Valid;

@Entity
public class Order1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Valid
	@OneToMany(mappedBy = "order1", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<OrderLine> orderLines = new ArrayList<>();

	private LocalDateTime createdAt;
	@Column(nullable = false)
	private String status;

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.status = "CREATED";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}