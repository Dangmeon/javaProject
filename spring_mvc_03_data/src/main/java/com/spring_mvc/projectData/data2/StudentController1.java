package com.spring_mvc.projectData.data2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController1 {
	
	@RequestMapping("/student/studentForm2")
	public String studentFormView2() {
		return "student/studentForm4";
	}
	
	@RequestMapping("/student/newStudent6")
	public String insertStudent6(Student1 student1) {
		
		return "student/studentResult4";
	}
}

// bean 충돌
// Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException: 
// Annotation-specified bean name 'studentController' for bean class [com.spring_mvc.projectData.data2.StudentController] 
// conflicts with existing, non-compatible bean definition of same name and class [com.spring_mvc.projectData.StudentController]
