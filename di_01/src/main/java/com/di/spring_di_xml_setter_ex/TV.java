package com.di.spring_di_xml_setter_ex;

public class TV {
	
	// Speaker 객체와 의존 관계를 가짐
	Speaker speaker;
	
	//스프링 XML의 <property name="speaker"> 태그가 이 세터 메서드를 호출하여 주입한다.
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
