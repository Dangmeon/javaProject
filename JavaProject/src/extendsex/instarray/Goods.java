package extendsex.instarray;

public class Goods {
	
	String name;
	int price;
	int stock;
	int sold;
	
	
	public Goods(String name, int price, int stock, int sold) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.sold = sold;
	}

	public void showGoodsInfo() {
		System.out.print(name + " ");
		System.out.print(price + " 원 ");
		System.out.print(stock + " 개 ");
		System.out.print(sold + " 개 ");
		System.out.println();
	}
}
