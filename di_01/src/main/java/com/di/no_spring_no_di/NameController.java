package com.di.no_spring_no_di;

public class NameController {
	// NameController입장에서 NameService는 의존 관계임
	// 필요한 곳에서 new 연산자를 사용해서 객체를 직접 생성(DI 아님)
	// nameService 의 제어권은 컨트롤러에 있음
	NameService nameService = new NameService();
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
