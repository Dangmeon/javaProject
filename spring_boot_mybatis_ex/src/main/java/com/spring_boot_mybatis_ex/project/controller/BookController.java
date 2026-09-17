package com.spring_boot_mybatis_ex.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis_ex.project.dto.BookDTO;
import com.spring_boot_mybatis_ex.project.service.BookService;

@Controller 
public class BookController {

    @Autowired
    BookService service;
    
    @RequestMapping("/")
    public String viewIndex() {
        return "index";
    }
    
    @RequestMapping("/book/listAllBook")
    public String listAllBook(Model model) {
        ArrayList<BookDTO> bookList = service.listAllBook(); 
        model.addAttribute("bookList", bookList);
        return "book/bookListView";
    }
    
    @RequestMapping("/book/detailViewBook/{bookNo}")
    public String detailViewBook(@PathVariable String bookNo, Model model) {
    	BookDTO dto = service.detailViewBook(bookNo);
    	model.addAttribute("dto", dto);
    	return "book/bookDetailView";
    }
    
    @RequestMapping("/book/newBookForm")
    public String newBookForm() {
    	return "book/newBookForm";
    }
    
    @RequestMapping("/book/insertBook")
    public String insertBook(BookDTO dto) {
    	service.insertBook(dto);
    	return "redirect:/book/listAllBook";
    }
    
    @RequestMapping("/book/updateBookForm/{bookNo}")
    public String updateBookForm(@PathVariable String bookNo, Model model) {
    	BookDTO dto = service.detailViewBook(bookNo);
    	model.addAttribute("book", dto);
    	return "book/updateBookForm";
    }
    
    @RequestMapping("/book/updateBook")
    public String updateBook(BookDTO dto) {
    	service.updateBook(dto);
    	return "redirect:/book/listAllBook";
    }
    
    @RequestMapping("/book/deleteBook/{bookNo}")
    public String deleteBook(@PathVariable String bookNo) {
    	service.deleteBook(bookNo);
    	return "redirect:/book/listAllBook";
    }
    
    @ResponseBody
    @RequestMapping("/book/bookNoCheck1")
    public String bookNoCheck1(@RequestParam("bookNo") String bookNo) {
    	String result = service.bookNoCheck(bookNo);
    	System.out.println(result);
    	return result;
    }
    
    @ResponseBody
    @RequestMapping("/book/bookNoCheck2")
    public String bookNoCheck2(@RequestBody String bookNo) {
    	String result = service.bookNoCheck(bookNo);
    	System.out.println(result);
    	return result;
    }
    
    @ResponseBody
    @RequestMapping("/book/bookNoCheck3")
    public String bookNoCheck3(@RequestBody HashMap<String, String> map) {
    	String bookNo = map.get("bookNo");
    	String result = service.bookNoCheck(bookNo);
    	System.out.println(result);
    	return result;
    }
    
    // 상품 검색
    @RequestMapping("/book/bookSearchForm1")
    public String viewBookSearchForm1() {
    	return "book/bookSearchForm1";
    }
    
    @ResponseBody
    @RequestMapping("/book/bookSearch1")
    public ArrayList<BookDTO> bookSearch1(@RequestParam HashMap<String, Object> map){
    	ArrayList<BookDTO> bookList = service.bookSearch(map);
    	return bookList;
    }
    
 // 상품 검색2
    @RequestMapping("/book/bookSearchForm2")
    public String viewBookSearchForm2() {
    	return "book/bookSearchForm2";
    }
    
    @RequestMapping("/book/bookSearch2")
    public String bookSearch2(@RequestParam HashMap<String, Object> map, Model model){
    	ArrayList<BookDTO> bookList = service.bookSearch(map);
    	model.addAttribute("bookList", bookList);
    	
    	return "book/bookSearchResultView";
    }
    
    // 상품 검색3
    @RequestMapping("/book/bookSearchForm3")
    public String viewBookSearchForm3() {
    	return "book/bookSearchForm3";
    }

}
