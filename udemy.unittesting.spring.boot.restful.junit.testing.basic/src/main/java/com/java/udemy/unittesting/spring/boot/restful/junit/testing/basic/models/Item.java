package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

	@Id
	private Integer id;
	private String name;
	private Integer price;
	private Integer quantity;
	
	@Transient  // we are saying that we do not want to save "value" in database
	private Integer value;
	
	protected Item() {}
	
	
	public Item(Integer id, String name, Integer price, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
