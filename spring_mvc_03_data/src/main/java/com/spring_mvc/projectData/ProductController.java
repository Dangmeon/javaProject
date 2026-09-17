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

/*
 * @Controller
 * 스프링 컨테이너에게 "이 클래스는 웹 요청(HTTP)을 처리하는 컨트롤러 역할을 한다"고 알려줌.
 * 프로젝트가 실행될 때 자동으로 메모리에 빈(Bean)으로 등록.
 */

@Controller
public class ProductController {

	@RequestMapping("/product/productResult")
	public String newViewT(Model model) {
		model.addAttribute("name", "홍감자");
		model.addAttribute("stock", 5);
		model.addAttribute("no", "1005");
		return "product/productResult";
	}

	/*
	 * 검색 폼 화면으로 이동하는 메서드
	 * 사용자가 검색 메뉴를 클릭했을 때 검색 조건을 입력할 수 있는 화면을 띄워준다.
	 */
	@RequestMapping("/product/prdSearchForm")
	public String productSeachForm() {
		return "product/prdSearchForm";
	}

	/*
	 * [방식 6] HashMap을 이용한 파라미터 동적 수집
	 * 폼에서 넘어오는 데이터(파라미터)의 종류가 가변적이거나 굳이 DTO 클래스를 새로 만들기 애매할 때,
	 * Map 객체를 활용하여 모든 파라미터를 한 주머니에 싹 쓸어 담는 방식이다.
	 * 
	 * 동작 원리:
	 * 1. @RequestParam 뒤에 Map(또는 HashMap)을 선언하면 스프링이 알아서 데이터를 매핑.
	 * 2. 폼 태그의 name 속성값(예: "type", "keyword")이 Map의 'Key'가 되고, 사용자가 입력한 값이 'Value'가 된다.
	 * 3. 컨트롤러 내부에서는 param.get("type") 형태로 손쉽게 값을 꺼내 쓸 수 있다.
	 * 
	 * 데이터 묶음(List) 뷰 전달:
	 * - DB에서 조회한 여러 개의 검색 결과(가짜 데이터 pd, pd2)를 ArrayList에 담는다.
	 * - Model 상자에 "prdList"라는 이름표를 붙여 리스트 전체를 JSP로 넘긴다.
	 * - JSP 화면에서는 JSTL의 <c:forEach> 태그를 이용해 리스트 안의 데이터를 반복해서 화면에 표나 목록으로 출력하게 된다.
	 */
	@RequestMapping("/product/prdSearch")
	public String productSearch(@RequestParam HashMap<String, Object> param, Model model) {

		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));

		Product pd = new Product();
		pd.setName("홍고구마");
		pd.setPrice(3000);
		pd.setMfg("고구마랜드");

		Product pd2 = new Product();
		pd2.setName("군감자");
		pd2.setPrice(5000);
		pd2.setMfg("감자행복길");

		ArrayList<Product> prdList = new ArrayList<>();
		prdList.add(pd);
		prdList.add(pd2);

		model.addAttribute("prdList", prdList);

		return "product/prdSearchResult";
	}

	/*
	 * @RequestMapping("/경로") 사용자가 브라우저에서 해당 URL로 요청을 보내면, 이 어노테이션이 붙은 메서드가 실행.
	 */
	@RequestMapping("/product/productForm")
	public String productForm() {
		return "product/productForm3";
	}

	/*
	 * [방식 1] 전통적인 방식 (HttpServletRequest 사용) 과거 JSP/Servlet 시절에 주로 쓰던 방식으로, 모든 데이터를
	 * 문자열(String)로만 받아옵니다.
	 * 
	 * 단점: 숫자 데이터(price, stock)를 연산하려면 Integer.parseInt()를 이용해 개발자가 일일이 형변환(문자열 ->
	 * 숫자)을 해줘야 하는 번거로움이 있다.
	 */
	@RequestMapping("/product/newProduct")
	public String insertProduct(HttpServletRequest request, Model model) {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String mfg = request.getParameter("mfg");
		String mfd = request.getParameter("mfd");
		int stock = Integer.parseInt(request.getParameter("stock"));

		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("price", price);
		model.addAttribute("mfg", mfg);
		model.addAttribute("mfd", mfd);
		model.addAttribute("stock", stock);

		return "product/productResult";
	}

	/*
	 * [방식 2] 스프링 방식 (@RequestParam 사용) 폼(form)에서 넘어오는 파라미터의 이름(name)과 메서드의 변수를 1:1로
	 * 직접 매핑.
	 * 
	 * 장점: 스프링이 알아서 형변환을 해준다. (파라미터를 int price로 선언하면 자동 변환됨) 가독성이 좋고, 필수 값 여부를 세팅할
	 * 수도 있다.
	 */
	@RequestMapping("/product/newProduct2")
	public String insertProduct2(@RequestParam("no") String no, @RequestParam("name") String name,
			@RequestParam("price") int price, @RequestParam("mfg") String mfg, @RequestParam("mfd") String mfd,
			@RequestParam("stock") String stock, Model model) {

		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("price", price);
		model.addAttribute("mfg", mfg);
		model.addAttribute("mfd", mfd);
		model.addAttribute("stock", stock);

		return "product/productResult";
	}

	/*
	 * [방식 3] 최적화 방식 (@RequestParam 생략) HTML form 태그의 name 속성값과 메서드의 매개변수(파라미터) 이름이
	 * "완벽하게 동일"하다면, @RequestParam 어노테이션조차 생략할 수 있다.
	 * 
	 * 장점: 코드가 가장 간결해지며, 숫자형(int) 자동 형변환도 그대로 지원됩니다. 간단한 파라미터를 받을 때 가장 많이 선호하는 방식.
	 */
	@RequestMapping("/product/newProduct3")
	public String insertProduct3(String no, String name, int price, String mfg, String mfd, int stock, Model model) {

		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("price", price);
		model.addAttribute("mfg", mfg);
		model.addAttribute("mfd", mfd);
		model.addAttribute("stock", stock);

		return "product/productResult";
	}

	/*
	 * [방식 4] 커맨드 객체(Command Object) 사용 - 표준 방식 폼에서 넘어오는 수많은 데이터를 하나씩 받지 않고, 묶음
	 * 상자(DTO/VO) 클래스를 만들어 한 번에 쓸어 담는 방식.
	 * 
	 * 동작 원리: 1. 스프링이 알아서 Product 객체를 생성. 2. 폼의 name 속성과 일치하는 setter(예: setPrice,
	 * setMfd)를 찾아 자동으로 값을 넣어주고 형변환. 3. 핵심: 수집된 객체는 Model.addAttribute()를 생략해도, 클래스
	 * 이름의 앞글자만 소문자로 바꾼 'product'라는 이름으로 뷰(JSP)에 자동 전달.
	 */
	@RequestMapping("/product/newProduct4")
	public String insertProduct4(Product product) {

		System.out.println(product.getNo());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getMfg());
		System.out.println(product.getMfd());
		System.out.println(product.getStock());

		return "/product/productResult3";
	}

	/*
	 * [방식 5] @ModelAttribute 사용 - 뷰(JSP)로 넘어가는 데이터의 이름표를 변경하고 싶을 때 기본적으로 방식 4와 동일하게
	 * 동작하여 데이터를 객체로 한 번에 수집.
	 * 
	 * 차이점: 방식 4는 JSP에서 무조건 ${product.name} 형태로 꺼내 써야 하지만,
	 * 
	 * @ModelAttribute("productInfo")를 붙이면 JSP로 넘어가는 택배 상자의 이름표가 지정한 이름으로 바뀐다. 즉,
	 * JSP 화면에서는 ${productInfo.name}, ${productInfo.price} 형태로 데이터를 꺼내야 한다.
	 */
	@RequestMapping("/product/newProduct5")
	public String insertProduct5(@ModelAttribute("productInfo") Product product) {

		System.out.println(product.getNo());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getMfg());
		System.out.println(product.getMfd());
		System.out.println(product.getStock());

		return "/product/productResult4";
	}

	@RequestMapping("/product/productDetail/{prdName}")
	public String productDetatil(@PathVariable String prdName) {

		System.out.println(prdName);

		return "product/productResult";
	}

	@RequestMapping("/product/productDetail2/{prdName}/{prdStock}/{prdNo}")
	public String productDetatil2(@PathVariable String prdName, @PathVariable int prdStock,
			@PathVariable String prdNo) {

		System.out.println(prdName);
		System.out.println(prdStock);
		System.out.println(prdNo);

		return "product/productResult";
	}

}
