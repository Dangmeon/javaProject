package com.spring_mvc.projectData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

	@RequestMapping("/bookInfoView1")
	public String showBookInfo1(Model model) {
		
		model.addAttribute("name", "스프링 프레임워크");
		model.addAttribute("price", 20000);
		
		return "book/bookInfoView1";
	}
	
	@RequestMapping("/bookInfoView2")
	public ModelAndView showBookInfo2(ModelAndView mv) {
		
		mv.addObject("name", "React 한 달만에 끝장내기");
		mv.addObject("price", 43000);
		
		mv.setViewName("book/bookInfoView2");
		
		return mv;
	}
}
