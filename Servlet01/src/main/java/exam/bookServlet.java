package exam;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookInsert")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	public void destroy() {
		System.out.println("destroy 실행");
	}


	/*
	 * form method post 요청 처리
	 * 1개의 파라미터 value 를 추출할 때 사용 : getParameter (input type text, password, radio 	1	개 값 전송)
	 * 동일 파라미터 명으로 여러 개의 파라미터가 전송되면 getParameter 는 처음 보이는 파라미터의 value 값만 반환
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String book_no = request.getParameter("book_no");
		String book_name = request.getParameter("book_name");
		String book_author = request.getParameter("book_author");
		String book_price = request.getParameter("book_price");
		String book_date = request.getParameter("book_date");
		String book_stock = request.getParameter("book_stock");
		String prd_no = request.getParameter("prd_no");

		System.out.println("도서번호 : " + book_no);
		System.out.println("도서명 : " + book_name);	
		System.out.println("저자 : " + book_author);
		System.out.println("가격 : " + book_price);		
		System.out.println("발행일 : " + book_date);		
		System.out.println("재고 : " + book_stock);		
		System.out.println("출판사번호 : " + prd_no);		

		
	}

}
