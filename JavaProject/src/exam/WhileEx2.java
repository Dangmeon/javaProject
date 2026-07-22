package exam;

import java.util.Scanner;

public class WhileEx2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num, score;
		int sum = 0;
		double avg = 0;
		
		System.out.print("학생 수 입력 : ");
		num = sc.nextInt();

        int i = 1; 
        
        while (i <= num) {
            System.out.print("학생" + i + " 점수 입력 : ");
            score = sc.nextInt();
            
            sum += score;
            
            i++;
        }
	
        if (num > 0) {
            avg = (double) sum / num;
        }

		System.out.println("평균 : " + avg);

	}

}
