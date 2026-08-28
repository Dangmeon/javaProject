package forward.binding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * redirect 시 binding 기능 활용
 */
@WebServlet("/bindingFirst")
public class BindingRedirectFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * redirect 진행
	 * Attribute 에 전달한 데이터를 저장해서 보냄
	 * request.setAttribute("attr이름", "attr값");
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("name", "홍길동");
		request.setAttribute("address", "서울시 강남구");
		
		response.sendRedirect("bindingSecond");
		//sendRedirect는 request/response 객체 소멸시킴
		// Attribute 는 객체와 같이 소멸됨
		// bindingSecond 는 새로운 request/response 를 전달받음 -> Attribute 없음
		// Attribute 는 request 객체가 소멸없이 전달되어야 사용가능

	}

}
