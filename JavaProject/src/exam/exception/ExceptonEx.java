package exam.exception;

import java.util.Scanner;

public class ExceptonEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Divide d = new Divide();
		
		System.out.print("num1 : ");			
		int num1 = sc.nextInt();
		
		System.out.print("num2 : ");	
		int num2 = sc.nextInt();
		
		try {
			
			d.divide(num1, num2);
			System.out.println("연산 결과: " + d.getDivide());		
			
		} catch (DivideArithmeticException e) {				
			
			System.out.println(e.getMessage());
			
		} finally {
			
			sc.close(); 
			
		}

		

	}

}
