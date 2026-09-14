package com.spring_mvc.jdbc2.dto;

import java.util.Date;

public class ProductDTO {
	
	private String prdNo;
	private String prdName;
	private String prdPrice;
	private String prdStock;
	private Date prdJoinDate;
	
	public ProductDTO() {
		
	}

	public ProductDTO(String prdNo, String prdName, String prdPrice, String prdStock, Date prdJoinDate) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdStock = prdStock;
		this.prdJoinDate = prdJoinDate;
	}

	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(String prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdStock() {
		return prdStock;
	}

	public void setPrdStock(String prdStock) {
		this.prdStock = prdStock;
	}

	public Date getPrdJoinDate() {
		return prdJoinDate;
	}

	public void setPrdJoinDate(Date prdJoinDate) {
		this.prdJoinDate = prdJoinDate;
	}
	

}
