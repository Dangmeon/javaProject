package com.di.spring_di_xml_constructor_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {
	
	public static void main(String[] args) {
		// XML 설정 파일 이름으로 스프링 컨테이너 구동
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context1_1.xml");
		
		// 스프링이 DI 구조로 조립해서 관리 중인 tv 객체(Bean) 꺼내오기
		TV tv = context.getBean("tv", TV.class);
		
		tv.volumeUp();
		tv.volumeDown();
	
		context.close();
	}
}


//개념: TV 객체가 동작하려면 Speaker 객체가 필요합니다. 이를 의존 관계라고 한다.
//목적: 자바 코드 내부에서 new 연산자로 직접 객체를 생성하여 결합하는 대신, 
//스프링 컨테이너(XML 설정을 통해)가 외부에서 Speaker 객체를 생성하여 TV 생성자 내부로 주입해 주는 결합 구조를 실습한다.

/*
	핵심 동작 요약
	1. TVMain이 실행되면 스프링 컨테이너가 application-context1_1.xml을 파싱한다.
	2. 스프링은 내부적으로 new Speaker()를 먼저 수행하여 메모리에 올린다.
	3. 이어서 new TV(speaker)를 호출하면서, 앞서 만든 스피커 객체를 생성자 매개변수로 안전하게 찔러 넣어 조립한다.
	4. 개발자는 소스코드 수정 없이 XML 설정 한 줄만 바꾸는 것만으로도 전체 프로그램의 부품(의존성 변수)을 
		손쉽게 변경할 수 있는 결합도 감소 효과를 얻게 된다.
*/