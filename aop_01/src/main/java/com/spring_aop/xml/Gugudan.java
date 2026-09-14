package com.spring_aop.xml;

import org.springframework.stereotype.Component;

// 핵심기능
@Component
public class Gugudan {
	private int dan;
	
	public int getDan() {
		return dan;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void showResult() {
		for(int i = 1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
	}

}
