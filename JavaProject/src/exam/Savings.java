package exam;
import java.util.Scanner;

public class Savings {
	
	Scanner sc = new Scanner(System.in);
	
	private String name;
	private int deposit;
	private double interest;
	private int balance;
	
	
	public void setName() {
		this.name = "홍길동";
	}
	
	public void setBalance() {
		this.balance = 10000;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void inputDeposit() {
		System.out.print("예금액 입력 : ");
		this.deposit  = sc.nextInt();
		this.balance += this.deposit;
	}
	
	public double getInterest() {
		this.interest = this.balance * 0.1;
		this.balance += this.interest;
		return this.interest;
	}
	
	public int getBalance() {
		return this.balance;
	}
}
