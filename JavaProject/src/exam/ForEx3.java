package exam;
import java.util.Scanner;

public class ForEx3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int start, end;
		int sum = 0;

		System.out.print("start 입력 : ");
		start = sc.nextInt();
		System.out.print("end 입력 : ");
		end = sc.nextInt();
		
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		System.out.print(start + " ~ " + end + "의 합 : " + sum);
		
		sc.close();
	}

}
