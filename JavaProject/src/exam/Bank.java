package exam;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int Withdraw = 0;
		int Deposit = 0;
		int Balance = 0;
		
		while(true) {
			
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("------------------------------------------------");
			
			System.out.print("선택> ");
			num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.print("예금액> ");
				Withdraw = sc.nextInt();
				Balance += Withdraw;
				break;
				
			case 2:
				System.out.print("출금액> ");
				Deposit = sc.nextInt();
				if(Balance < Deposit) {
					System.out.println("잔액부족. 현재 잔액 : " + Balance);
				}
				Balance -= Deposit;
				break;
			
			case 3:
				System.out.println("잔고> " + Balance);
				break;
				
			case 4:
				System.out.println();
				System.out.println("프로그램 종료");
				sc.close();
				return;

			default:
				break;
			}
			
		}
				
	}

}
