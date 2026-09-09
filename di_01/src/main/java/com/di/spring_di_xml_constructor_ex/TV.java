package com.di.spring_di_xml_constructor_ex;

public class TV {
	
	// Speaker 객체와 의존 관계를 가짐
	Speaker speaker;
	
	// 스프링 XML의 <constructor-arg> 태그가 이 통로를 통해 객체를 조립(주입)한다.
	public TV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
