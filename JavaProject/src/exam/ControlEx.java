package exam;
import java.util.Scanner;

public class ControlEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, num2;
		int rap = 1200000;
		int cam = 400000;
		int total, dis;
		int price = 0;
		
		System.out.println("******상품 정보******");
		System.out.println("1 노트북 : 1,200,000 원");
		System.out.println("2 디지털카메라 : 400,000 원");
		System.out.println("*******************");
		
		System.out.print("상품번호 입력 : ");
		num = sc.nextInt();
		System.out.print("주문 수량 입력 : ");
		num2= sc.nextInt();
		
		if(num == 1 || num == 2) {
			if(num == 1) {
				System.out.println("상품명 : 노트북");
				price = rap;
			} else if(num == 2) {
				System.out.println("상품명 : 디지털카메라");
				price = cam;
			}
			total = price * num2;
			
			if(total > 1000000) {
				dis = (int)(total * 0.1);
			} else if (total > 500000) {
				dis = (int)(total * 0.05);
			} else {
				dis = 0; 
			}

			System.out.println("가격 : " + price +  " 원");
			System.out.println("주문 수량 : " + num2);
			System.out.println("주문액 : " + total + "원");
			System.out.println("할인액 : " + dis + "원");
			System.out.println("총지불액 : " + (total - dis) + "원");
			
		} else {
			System.out.print("잘못 입력하였습니다. 종료합니다.");
		}

	}

}