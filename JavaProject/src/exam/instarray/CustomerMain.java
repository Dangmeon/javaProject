package exam.instarray;

import java.util.Scanner;

import extendsex.instarray.Goods;

public class CustomerMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String no;
		String name;
		String pn;
		String job;
		String gender;
		int age;
		
		Customer[] c = new Customer[3];
		
		System.out.println("**** 고객 정보 입력 ****");
		
		for(int i = 0; i < c.length; i++) {
			System.out.print("\n고객번호 : " );
			no = sc.next();
			System.out.print("고객명 : " );
			name = sc.next();
			System.out.print("전화번호 : " );
			pn = sc.next();
			System.out.print("직업 : " );
			job = sc.next();
			System.out.print("성별 : " );
			gender = sc.next();
			System.out.print("나이 : " );
			age = sc.nextInt();
			// 객체 생성 시 생성자 호출되면서 인수값 전달
			c[i] = new Customer(no, name, pn, job, gender, age);
		}
		
		System.out.println("**** 고객 정보 출력 ****");
		
		for(int i = 0; i < c.length; i++) {
			c[i].showCustomerInfo();
		}

	}

}
