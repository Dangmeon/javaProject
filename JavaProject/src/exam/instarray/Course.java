package exam.instarray;

import java.util.Scanner;

public class Course {
	
	Scanner sc = new Scanner(System.in);
	
	private String name;
	private String proName;
	private int year;
	private int grade;
	
	public void input() {
		System.out.println();
		System.out.print("과목명 입력 : ");
		this.name = sc.next();
		System.out.print("교수 입력 : ");
		this.proName = sc.next();
		System.out.print("학년 : ");
		this.year = sc.nextInt();
		System.out.print("이수 학점 : ");
		this.grade = sc.nextInt();
	}
	
	public void output() {
		System.out.print(name + " ");
		System.out.print(proName + " ");
		System.out.print(year + "학년 ");
		System.out.print(grade + "학점 ");
		System.out.println();
	}
	

}
