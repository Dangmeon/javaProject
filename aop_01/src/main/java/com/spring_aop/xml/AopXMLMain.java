package com.spring_aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopXMLMain {

	public static void main(String[] args) {
		//스프링 컨테이너 객체 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		
		// 핵심 기능 1
		Rect rect = context.getBean("rect", Rect.class);
		rect.showResult();
		
		// 핵심기능 2
		Gugudan gugudan = context.getBean("gugudan", Gugudan.class);
		gugudan.showResult();
		
		context.close();
	}

}
