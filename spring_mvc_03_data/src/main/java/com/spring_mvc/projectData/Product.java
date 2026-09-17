package com.spring_mvc.projectData;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	
	private String no;
	private String name;
	private int price;
	private String mfg;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate mfd;
	private int stock;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMfg() {
		return mfg;
	}
	public void setMfg(String mfg) {
		this.mfg = mfg;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
