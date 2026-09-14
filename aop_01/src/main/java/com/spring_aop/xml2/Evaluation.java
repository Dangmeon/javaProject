package com.spring_aop.xml2;

import org.springframework.stereotype.Component;

// 핵심 기능 1
@Component
public class Evaluation {
	
	private int korean;
	private int english;
	private int math;
	
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public void showResult() {
		System.out.println("총점 : " + (korean + english + math));
		System.out.println("평균 : " + (korean + english + math)/3);
	}
	

}
