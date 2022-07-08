package com.example.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product2")

public class Product {
	
	
		public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
		public Product(long id, String name, String brand, float price, String madein) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.madein = madein;
	}
		public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column
		private String name;
			
		@Column
		private String brand;
		@Column
		private float price;
		@Column
		private String madein;
}
		
