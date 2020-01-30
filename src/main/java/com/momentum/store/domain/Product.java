package com.momentum.store.domain;

import org.springframework.data.annotation.Id;

public class Product {
	@Id private int id;
	private String name;
	private String code;
	private Integer pointCost;
	
	public Product() {
		//default constructor
	}
	
	public Product(int id,String name, String code, Integer pointCost) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.pointCost = pointCost;
	}
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPointCost() {
		return pointCost;
	}

	public void setPointCost(Integer pointCost) {
		this.pointCost = pointCost;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", pointCost=" + pointCost + "]";
	}

	
	
	
	
}
