package com.di.spring_di_annotation.configuration_bean;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 의존성(DI)과 클래스 bean 등록과 관련된 설정을 xml이 아닌 클래스로 구성
@ComponentScan("com.di.spring_di_annotation.configuration_bean")
@Configuration
public class ApplicationConfig {
	// @Bean 이 적용된 메소드는 반드시 bean 객체를 반환
	@Bean
	public BMI bmi() {
		BMI bmi = new BMI();
		return bmi;
	}
	
	@Bean
	public Member member() {
		ArrayList<String> course = new ArrayList<>();
		course.add("수영");
		course.add("헬스");
		course.add("에어로빅");
		
		Member member = new Member();
		member.setBmi(bmi());
		member.setName("홍감자");
		member.setAge(23);
		member.setHeight(175);
		member.setWeight(70);
		member.setCourses(course);
		
		return member;
	}
}
