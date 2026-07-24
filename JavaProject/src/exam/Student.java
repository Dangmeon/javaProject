package exam;
import java.util.Scanner;

public class Student {
	
	Scanner sc = new Scanner(System.in);
	
	private int stdNo;
	private String stdName;
	private int year;
	private int score;
	
	public void inputStdInfo() {
		System.out.print("학번 : ");
		stdNo = sc.nextInt();
		System.out.print("성명 : ");
		stdName = sc.next();
		System.out.print("학년 : ");
		year = sc.nextInt();
		System.out.print("점수 : ");
		score = sc.nextInt();

	}
	
	public void showStdInfo() {
		System.out.println("학번 : " + stdNo);
		System.out.println("성명 : " + stdName);
		System.out.println("학년 : " + year);
		System.out.println("점수 : " + score);
	}
	

	public static void main(String[] args) {
		Student st = new Student();
		
		System.out.println("**** 학생 정보 입력 ****"); 
		st.inputStdInfo();
		
		System.out.println("\n**** 학생 정보 출력 ****");
		st.showStdInfo();
		
	}

}
