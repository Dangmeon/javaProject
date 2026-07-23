package exam;
import java.util.Scanner;

public class ArrayInputEx1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int score[] = new int[5];
		int max = score[0];
		
		System.out.println("숫자 입력 : "+ " ");
		
		for(int i = 0; i < score.length; i++) {
			System.out.printf("num[%d] : ", i);
			score[i] = sc.nextInt();
			
			max = Math.max(max, score[i]);
		}
		
		System.out.print("입력된 값 :" + " ");
		for(int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println("\n최대값 : " + max);
		
	}

}
