package exam;
import java.util.Scanner;

public class Score_ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[3]; 
		int count;
		
		while(true) {
			System.out.println("\n----------------------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------------------------------------------------------------");
			System.out.print("선택> ");
			count = sc.nextInt();
			
			switch(count) {
			case 1:
				System.out.print("학생수> " + score.length);
				break;
				
			case 2:
				if(score == null) {
					System.out.println("먼저 학생 수를 입력해 주세요.");
					break;
				}
				for(int i = 0; i < score.length; i++) {
					System.out.print("scores[" + i + "]> ");
					score[i] = sc.nextInt();
				}
				break;
			case 3:
				if(score == null) {
					System.out.println("먼저 학생 수를 입력해 주세요.");
					break;
				}
				for(int i = 0; i < score.length; i++) {
					System.out.println("scores[" + i + "]: " + score[i]);
				}
				break;
			case 4:
				if(score == null) {
					System.out.println("먼저 학생 수를 입력해 주세요.");
					break;
				}
				int max = 0;
				int sum = 0;
				for(int i = 0; i < score.length; i++) {
					max = Math.max(max, score[i]);
					sum += score[i];
				}
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + ((float)sum / score.length)); 
				break;
			case 5:
				System.out.println("프로그램 종료");
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}