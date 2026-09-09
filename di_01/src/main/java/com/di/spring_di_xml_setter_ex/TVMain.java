package com.di.spring_di_xml_setter_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {
	
	public static void main(String[] args) {
		// XML 설정 파일 이름으로 스프링 컨테이너 구동
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2_1.xml");
		
		// 스프링이 DI 구조로 조립해서 관리 중인 tv 객체(Bean) 꺼내오기
		TV tv = context.getBean("tv", TV.class); // Speaker 객체가 setter 통해서 주입됨
		
		tv.volumeUp();
		tv.volumeDown();
	
		context.close();
	}
}

/*
 *  개념: TV 객체가 필요로 하는 Speaker 부품을 생성자 대신 수정자 메서드(Setter Method)를 통해 주입하는 방식이다.
 *  목적: 스프링 컨테이너가 기본 생성자로 객체를 먼저 생성한 후, XML의 <property> 태그를 이용해 setSpeaker() 메서드를 호출하여 
 *  의존성 객체를 주입(Injection)하는 흐름을 실습한다.
 */

/*
 * 	1. TVMain이 실행되면 스프링 컨테이너가 application-context2_1.xml 지시서를 읽는다.
 * 	2. 스프링은 new Speaker()와 매개변수가 없는 기본 생성자인 new TV()를 각각 호출하여 빈 객체들을 메모리에 올린다.
 * 	3. 지시서의 <property name="speaker" ref="speaker"/> 설정을 보고, tv 객체의 setSpeaker(speaker) 메서드를 내부적으로 호출하여 
 * 		부품을 끼워 넣는다.
 * 	4. 조립이 완전히 끝난 tv 빈을 개발 코드가 꺼내 쓰기 때문에 의존성 관계가 안전하게 유지된다.
 */