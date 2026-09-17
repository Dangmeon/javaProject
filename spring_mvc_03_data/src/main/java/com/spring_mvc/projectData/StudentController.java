package com.spring_mvc.projectData;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	// 경로 테스트용 메소드
	@RequestMapping("/newView")
	public String newViewT(Model model) {
		model.addAttribute("name", "홍감자");
		model.addAttribute("no", "1001");
		model.addAttribute("year", "2");
		return "newView";
	}
	
	// 서로 다름 타입 데이터의 전송 - 검색 관련
	// 검색 관련 폼 반환
	@RequestMapping("/student/studentSearchForm")
	public String studentSeachForm() {
		return "student/studentSearchForm";
	}
	
	// 검색 폼에서 전달된 파라미터 값을 받아서 HashMap에 받아서 dao에서 활용하도록 전달
	// dao에서 검색한 학생 data가 컨트롤러로 전달되었다고 가정
	@RequestMapping("/student/studentSearch")
	public String studentSearch(@RequestParam HashMap<String, Object> param, Model model) {
		// param 값 출력 : key로 value 찾아서 출력 -> 파라미터명이 key, 파라미터 값이 value
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		
		// 검색 결과를 view에 전달하기 위한 준비
		Student vo1 = new Student();
		vo1.setNo("1001");
		vo1.setName("홍감자");
		vo1.setYear(2);
		
		Student vo2 = new Student();
		vo2.setNo("1002");
		vo2.setName("홍고구마");
		vo2.setYear(4);
		
		ArrayList<Student> stdList = new ArrayList<>();
		stdList.add(vo1);
		stdList.add(vo2);
		
		model.addAttribute("stdList", stdList);

		return "student/studentSearchResult";
	}
	
	// URI를 통한 데이터 전달 받기
	@RequestMapping("/student/studentDetatilView/{stdNo}") // stdNo pathVariable과
	public String studentDetatilView(@PathVariable String stdNo) { // 매개변수 stdNo는 동일해야 함
		System.out.println(stdNo);
		return "student/studentResult5";
	}
	// URI를 통한 여러 데이터 전달 받기
	@RequestMapping("/student/studentDetatilView/{stdNo}/{stdName}/{stdYear}") 
	public String studentDetatilView1(@PathVariable String stdNo,
															@PathVariable String stdName,
															@PathVariable String stdYear) {
		System.out.println(stdNo);
		System.out.println(stdName);
		System.out.println(stdYear);

		return "student/studentResult5";
	}
	
	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm3";
	}
	
	@RequestMapping("/student/newStudent")
	public String insertStudent(HttpServletRequest request, Model model) {
		// form에서 각 input 태그의 name 속성값 받아오기
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		// view로 전달
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 2. @RequestParam 이용 - 처리 함수의 매개변수로 주입
	@RequestMapping("/student/newStudent2")
	public String insertStudent2(@RequestParam("no") String no, 
													@RequestParam("name") String name, 
													@RequestParam String year, 
													Model model) {
		
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 2-2. @RequestParam 이용 - 처리 함수의 매개변수로 주입
	// form 태그 내 input 의 name 속성값이 매개변수와 동일하면 @RequestParam을 생략할 수 있다.
	// 
	@RequestMapping("/student/newStudent3")
	public String insertStudent3(String no, 
													String name, 
													String year, 
													Model model) {
		
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 3. command 객체 사용 -> 요청 처리에 사용되는 객체 command 객체라고 함 매개변수에 사용됨
	// student command 객체가 되고 파라미터가 전달된다면 필드명과 같은 이름의 파라미터 값이 필드값으로 대입된 객체가 전달됨\
	// command 객체를 사용하면 지정된 뷰로 model이 자동 전송됨 -> model에 command 객체가 포함되어서 전송
	// command 객체 사용시 주의사항 : 파라미터 명과 필드명이 동일해야함 다르면 매칭되지 않는다(null 이 저장됨)
	@RequestMapping("/student/newStudent4")
	public String insertStudent4(Student student) {
		
		System.out.println(student.getNo());
		System.out.println(student.getName());
		System.out.println(student.getYear());

		return "student/studentResult2";
	}
	
	// 3-1. command 객체 사용
	// attr의 이름을 변경해서 view로 전달 -> @ModelAttribute("새로운 이름") 사용해서 변경
	@RequestMapping("/student/newStudent5")
	public String insertStudent5(@ModelAttribute("studentInfo") Student student) { // 매개변수명이 아닌 StudentInfo로 attr의 이름이 설정
		
		System.out.println(student.getNo());
		System.out.println(student.getName());
		System.out.println(student.getYear());

		return "student/studentResult3";
	}
	
}
