package exam.ojdbc;

import java.util.Date;

public class ProductVo {

	private String prdNo;
	private String name;
	private int price;
	private int stock;
	Date joinDate;

	public ProductVo() {

	}

	public ProductVo(String prdNo, String name, int price, int stock) {
		this.prdNo = prdNo;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	

}
