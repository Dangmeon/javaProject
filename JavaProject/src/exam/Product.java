package exam;
import java.util.Scanner;

public class Product {
	
	Scanner sc = new Scanner(System.in);
	
	private String prdName;
	private int prdPrice;
	private int prdSold;
	private int prdStock;

	
	public void inputPrdInfo() {
		System.out.print("상품명 : ");
		prdName = sc.next();
		System.out.print("가격 : ");
		prdPrice = sc.nextInt();
		System.out.print("판매 수량 : ");
		prdSold = sc.nextInt();
		System.out.print("재고 수량 : ");
		prdStock = sc.nextInt();
	}
	
	void showPrdInfo() {
		System.out.println("상품명 : " + prdName);
		System.out.println("가격 : " + prdPrice);
		System.out.println("판매 수량 : " + prdSold);
		System.out.println("재고 수량 : " + prdStock);
	}
	
	void salesAmount() {
		int sales = prdPrice * prdSold;
		System.out.println("판매액 : " + sales);
	}
	
	void stockAmount() {
		int stock = prdPrice * prdStock;
		System.out.println("재고액 : " + stock);
	}
	
	public static void main(String[] args) {
		Product pd = new Product();
		
		System.out.println("**** 상품 정보 입력 ****"); 
		pd.inputPrdInfo();
		
		System.out.println("\n**** 상품 정보 출력 ****");
		pd.showPrdInfo();
		pd.salesAmount();
		pd.stockAmount();
	}

}
