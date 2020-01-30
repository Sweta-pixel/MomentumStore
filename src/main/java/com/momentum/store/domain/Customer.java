package com.momentum.store.domain;

import org.springframework.data.annotation.Id;

public class Customer {
	@Id
	private int id;
	private String name;
	private Integer activePoints;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActivePoints() {
		return activePoints;
	}

	public void setActivePoints(Integer activePoints) {
		this.activePoints = activePoints;
	}

	public Customer() {
		// default constructor
	}

	public Customer(int id, String name, Integer activePoints) {
		super();
		this.id = id;
		this.name = name;
		this.activePoints = activePoints;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", activePoints=" + activePoints + "]";
	}

}
