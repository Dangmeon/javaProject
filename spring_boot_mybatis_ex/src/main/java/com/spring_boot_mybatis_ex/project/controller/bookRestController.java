package com.spring_boot_mybatis_ex.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_mybatis_ex.project.dto.BookDTO;
import com.spring_boot_mybatis_ex.project.service.BookService;

@RestController
public class bookRestController {
	@Autowired
	BookService service;
	
    @RequestMapping("/book/bookSearch3")
    public ArrayList<BookDTO> bookSearch3(@RequestParam HashMap<String, Object> map){
    	ArrayList<BookDTO> bookList = service.bookSearch(map);
    	return bookList;
    }
    

}
