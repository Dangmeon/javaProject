package com.di.spring_di_annotation_ex3;

import org.springframework.stereotype.Component;

/*
 * [동작 순서 2단계: Speaker 빈(Bean) 생성]
 * 컴포넌트 스캔 중 @Service 어노테이션을 발견.
 * 스프링은 "이 클래스는 비즈니스 로직을 담당하는 부품" 이라고 인식하고,
 * 메모리에 Speaker 객체를 생성하여 스프링 컨테이너에 보관한다.
 */

@Component
public class Speaker {
	
	public void volumeUp() {
		System.out.println("볼륨을 키웁니다.");
	}
	
	public void volumeDown() {
		System.out.println("볼륨을 낮춥니다.");
	}

}
