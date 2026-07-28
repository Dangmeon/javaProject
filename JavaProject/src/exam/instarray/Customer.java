package exam.instarray;

import java.util.Scanner;

public class Customer {
	
	String no;
	String name;
	String pn;
	String job;
	String gender;
	int age;
	
	
	public Customer(String no, String name, String pn, String job, String gender,  int age) {
		this.no = no;
		this.name = name;
		this.pn = pn;
		this.job = job;
		this.gender = gender;
		this.age = age;
	}

	public void showCustomerInfo() {
		System.out.print(no + " ");
		System.out.print(name + " ");
		System.out.print(pn + " ");
		System.out.print(job + " ");
		System.out.print(gender + " ");
		System.out.print(age + " ");
		System.out.println();
	}

}
