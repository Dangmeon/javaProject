package com.spring_mvc.jdbc2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.jdbc2.dao.ProductDAO;
import com.spring_mvc.jdbc2.dto.ProductDTO;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO prdDao;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/product/productSelect")
	public String prdSelect(Model model) {
		
		ArrayList<ProductDTO> prdList = prdDao.productSelect();
		
		model.addAttribute("prdList",prdList);
		
		return "/product/productListView";
	}

}
