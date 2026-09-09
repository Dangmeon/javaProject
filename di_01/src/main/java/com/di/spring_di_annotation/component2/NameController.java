package com.di.spring_di_annotation.component2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class NameController {
	@Autowired
	INameInterface nameService; // name 속성을 생략하는 필드이름과 동일한 id 의 bean을 찾음
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
