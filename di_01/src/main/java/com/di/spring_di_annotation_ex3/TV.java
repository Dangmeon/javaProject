package com.di.spring_di_annotation_ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/*
 * [동작 순서 3단계: TV 빈(Bean) 생성 및 이름 부여]
 * 컴포넌트 스캔이 @Component("tv")를 발견.
 * 스프링은 메모리에 TV 객체를 생성하고, 컨테이너에 보관할 때 'tv'라는 이름표를 붙여둔다.
 */

@Component("tv")
public class TV {
	
	/*
	 * [동작 순서 4단계: 의존성 자동 주입 (DI)]
	 * TV 객체를 만들고 보니 내부에 @Autowired가 붙은 변수가 있다.
	 * 스프링은 컨테이너를 뒤져서 2단계에서 미리 만들어둔 'Speaker' 타입의 객체를 찾아낸다.
	 * 그리고 개발자 대신 이 'speaker' 변수에 해당 객체를 자동으로 쏙 끼워 넣어준다. (필드 주입)
	 */
	
	// Speaker 객체와 의존 관계를 가짐
	@Autowired
	Speaker speaker;
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
