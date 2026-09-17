package com.spring_boot_mybatis_ex.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis_ex.project.dto.BookDTO;

public interface IBookService {
	void insertBook(BookDTO bookDto);
	
	void updateBook(BookDTO bookDto);
	
	void deleteBook(String bookNo);

    ArrayList<BookDTO> listAllBook(); 
    
    BookDTO detailViewBook(String bookNo);
    
    String bookNoCheck(String bookNo);
    
    ArrayList<BookDTO> bookSearch(HashMap<String, Object> map); 
}
