package com.spring_mvc.mybatis.controller;

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

import com.spring_mvc.mybatis.dto.ProductDTO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductDTO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productListView";
	}
	
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	/*
	 * 파라미터로 폼데이터가 전달
	 * command 객체를 활용해서 저장 - command 객체를 통해 비지니스 로직 처리
	 * 새로운 상품이 등록되면 상품정보 조회로 redirect
	 * 현재 요청에 대한 응답처리하고 재요청을 클라이언트가 진행하게끔 구성
	 */
	
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductDTO dto) {
		service.insertProduct(dto); // 완료신호 반환되면 저장되었다는 신호 이므로 다음 내용 진행
		return "redirect:/product/listAllProduct";
	}
	
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductDTO dto = service.detailViewProduct(prdNo);
		model.addAttribute("dto", dto);
		return "product/productDetailView";
	}

	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		ProductDTO dto = service.detailViewProduct(prdNo);
		model.addAttribute("prd", dto);
		return "product/updateProductForm";
	}
	
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductDTO dto) {
		System.out.println(dto.getPrdNo());
		service.updateProduct(dto);
		return "redirect:/product/listAllProduct";
	}
	
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		service.deleteProduct(prdNo);
		return "redirect:/product/listAllProduct";
	}
	
	// 상품 번호 중복 확인 : ajax post 방식 - 파라미터 전달
	// rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
		String result = service.prdNoCheck(prdNo); // 상품 번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	// 상품 번호 중복 확인2 : ajax get 방식
	// rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck1/{prdNo}")
	public String prdNoCheck1(@PathVariable String prdNo) {
		String result = service.prdNoCheck(prdNo); // 상품 번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	// 상품 번호 중복 확인3 : post - request Body를 통해 data 전달
	// rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck4")
	public String prdNoCheck4(@RequestBody String prdNo) {
		String result = service.prdNoCheck(prdNo); // 상품 번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	// 상품 번호 중복 확인4 : axios get의 요청
	// axios 는 응답방식을 서버에게 요청하게 됨 스프링 컨테이너가 해당 요청을 처리할 때 data 필드에 반환값을 담아서 전송
	// rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck5/{prdNo}")
	public String prdNoCheck5(@PathVariable String prdNo) {
		String result = service.prdNoCheck(prdNo); // 상품 번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	// 상품 번호 중복 확인5 : axios post의 요청시 전잘되는 data는 key:value 타입으로 전달, 컨트롤러에서는 k:v 타입을 저장할 수 있는 객체를 활용헤야 함
	@ResponseBody
	@RequestMapping("/product/prdNoCheck6")
	public String prdNoCheck6(@RequestBody HashMap<String, String> map) {
		String prdNo = map.get("prdNo");
		String result = service.prdNoCheck(prdNo); // 상품 번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	
	
	///////////////////////////////////////////////////////////////////////
	//상품 검색 기능
	
	// 상품 검색 폼 요청
	@RequestMapping("/product/productSearchForm1")
	public String viewProductSearchForm1() {
		return "product/productSearchForm1";
	}

	/*
	 * [방식 1] @ResponseBody를 활용한 데이터(JSON) 반환 방식
	 * 일반적인 @Controller 안에서 특정 메서드만 데이터를 반환하고 싶을 때 사용.
	 * 
	 * 특징: 반환되는 ArrayList 객체를 스프링(Jackson 라이브러리)이 자동으로 JSON 배열로 변환해 준다.
	 * 프론트엔드 처리: 자바스크립트가 JSON 데이터를 받아 직접 for문을 돌면서 
	 *              <tr>, <td> 태그를 일일이 조립(.append)해서 화면에 그려야 한다.
	 */
	
	// 상품 검색 메소드 1 - ArrayList 객체를 스프링 컨테이너에세 반환하면 컨테이너는 json 형식으로 변환 후
	// 클라이언트에게 전송 - jackson-databind 의존 객체가 필요
	@ResponseBody // rest pool 상태로 응답 진행
	@RequestMapping("/product/productSearch1")
	public ArrayList<ProductDTO> productSearch1(@RequestParam HashMap<String, Object> map){
	// public ArrayList<ProductDTO> productSearch1(@RequestParam String type, @RequestParam String keyword){
		ArrayList<ProductDTO> prdList = service.productSearch(map);
		
		return prdList;
	}
	
	
	// 상품 검색 폼 요청 2
	@RequestMapping("/product/productSearchForm2")
	public String viewProductSearchForm2() {
		return "product/productSearchForm2";
	}
	
	/*
	 * [방식 2] Model과 JSP(View)를 활용한 HTML 통째로 반환 방식
	 * @ResponseBody 없이 전통적인 MVC 패턴처럼 Model에 데이터를 담아 JSP 화면을 반환.
	 * 
	 * 특징: 서버(JSP) 쪽에서 JSTL(<c:forEach>)을 사용해 미리 테이블 태그를 모두 완성해 둔다.
	 * 프론트엔드 처리: 자바스크립트는 복잡한 for문 없이, 완성된 HTML 코드 덩어리를 
	 *              받아와서 .html(result) 단 한 줄로 화면에 끼워 넣기만 하면 된다.
	 * 장점: 프론트(JS) 코드가 획기적으로 짧아지며, jQuery 환경에서 화면을 깜빡임 없이 새로고침할 때 아주 유용하다.
	 */
	
	// 상품 검색 메소드 2 - view 페이지 반환
	// @ResponseBody : 반환하는 문자열을 JSP 파일 이름으로 찾지 말고, 그냥 글자 그대로 브라우저에 던지라는 뜻과 같음
	@RequestMapping("/product/productSearch2")
	public String productSearch2(@RequestParam HashMap<String, Object> map, Model model){
	// public ArrayList<ProductDTO> productSearch1(@RequestParam String type, @RequestParam String keyword){
		ArrayList<ProductDTO> prdList = service.productSearch(map);
		model.addAttribute("prdList", prdList);
		
		return "product/productSearchResultView";
	}
	
	// 상품 검색 폼 요청 3
	@RequestMapping("/product/productSearchForm3")
	public String viewProductSearchForm3() {
		return "product/productSearchForm3";
	}
}
