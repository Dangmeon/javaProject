package exam;
import java.util.Scanner;

public class ForEx4 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int num;
		int countP = 0;
		int countM = 0;
		int countZ = 0;

		for(int i = 1; i <= 10; i++) {
			System.out.print("숫자" + i + " 입력 : ");
			num = sc.nextInt();
			
			if(num > 0) {
				countP++;
			}else if (num < 0) {
				countM++;
			}else {
				countZ++;
			}

		}
		
		System.out.println("양의 개수 : " + countP);
		System.out.println("음의 개수 : " + countM);
		System.out.println("0의 개수 : " + countZ);
		
		sc.close();
	
	}

}
