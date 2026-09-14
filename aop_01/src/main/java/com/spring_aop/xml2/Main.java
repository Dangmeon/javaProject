package com.spring_aop.xml2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config1-2.xml");
		
		Evaluation evaluation = context.getBean("evaluation", Evaluation.class);
		evaluation.showResult();
		
		Circle circle = context.getBean("circle", Circle.class);
		circle.showResult();
		
		context.close();
	}

}
