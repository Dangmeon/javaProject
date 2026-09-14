package com.spring_mvc.second;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {

	@RequestMapping("/second")
	public String newController(Model model) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String currentTime = dateFormat.format(new Date());
		
		model.addAttribute("serverTime", currentTime);
		
		return "index";
	}
}
