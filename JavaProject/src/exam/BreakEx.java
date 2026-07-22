package exam;
import java.util.Scanner;


public class BreakEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int total = 100000;
		int minusM = 0;
		int current = 0;
		
		System.out.println("현재 잔액 : " + total);
		
		while(true) {
			System.out.print("인출액 입력 : ");
			minusM = sc.nextInt();
			
			if(total < minusM) {
				System.out.println("잔액부족. 현재 잔액 : " + total);
				break;
			}
			total -= minusM;
		}
		
		sc.close();
	}

}
