package com.spring_boot_mybatis.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_mybatis.project.dto.ProductDTO;
import com.spring_boot_mybatis.project.service.ProductService;

/*
 * 	이 클래스는 rest api 를 구현하는 클래스(컨트롤러)
 * 	모든 메소드에 @ResponseBody를 첨부하는 것과 같음
 * */
@RestController
public class ProductRestController {
	@Autowired
	ProductService service;
	
	/*
	 * [방식 3] @RestController를 활용한 최신 REST API 방식 (실무 표준)
	 * 클래스 자체를 @RestController로 선언하여, 화면(View) 대신 데이터(JSON)만 전문적으로 제공하는 API 공장을 만든다.
	 * 
	 * 특징: 클래스 내부의 모든 메서드에 자동으로 @ResponseBody가 적용된 것과 같은 효과를 가진다.
	 * 프론트엔드 처리: 1번 방식과 동일하게 dataType: "json"으로 데이터를 받아 JS에서 화면을 직접 그린다.
	 * 장점: 화면을 담당하는 컨트롤러와 데이터를 담당하는 컨트롤러를 완벽하게 분리할 수 있다. 
	 *      향후 React, Vue.js 같은 최신 프론트엔드 프레임워크와 연동할 때 100% 사용되는 아키텍처이다.
	 */

	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductDTO> productSearch1(@RequestParam HashMap<String, Object> map){
		ArrayList<ProductDTO> prdList = service.productSearch(map);
		
		return prdList;
	}
}
