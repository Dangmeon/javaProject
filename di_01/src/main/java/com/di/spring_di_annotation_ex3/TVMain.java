package com.di.spring_di_annotation_ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {
	
	public static void main(String[] args) {
		/*
		 * [동작 순서 1단계 트리거: 스프링 컨테이너 구동]
		 * XML 파일을 읽어오면서 스프링 컨테이너가 가동.
		 * 실행되는 순간, 내부적으로 앞서 설명한 1~4단계(스캔 -> 빈 생성 -> 의존성 주입)가 순식간에 모두 완료되게 된다.
		 */
		
		// XML 설정 파일 이름으로 스프링 컨테이너 구동
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config3_1.xml");
		
		
		/*
		 * [동작 순서 5단계: 완성된 객체(Bean) 꺼내 쓰기]
		 * 조립이 모두 끝난 컨테이너에서 'tv'라는 이름표가 붙은 객체를 꺼내온다.
		 * 개발자가 new TV(), new Speaker()를 직접 하지 않았음에도 이미 TV 안에는 Speaker가 들어가 있다.
		 */
		
		TV tv = context.getBean("tv", TV.class);
		
		tv.volumeUp();
		tv.volumeDown();
	
		context.close();
	}
}
