package com.di.no_spring_di_constructor;

public class NameController {
	// NameController입장에서 NameService는 의존 관계임
	NameService nameService;
	// NameService nameService = new NameService(); // 결합 방식
	
	public NameController(NameService nameService) { 
		this.nameService = nameService;
	}

	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
