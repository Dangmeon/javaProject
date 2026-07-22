package exam;
import java.util.Scanner;

public class IfElseEx1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		if(num % 2 == 0)
			System.out.print("짝수");
		else
			System.out.print("홀수");

		
		sc.close();

	}

}
