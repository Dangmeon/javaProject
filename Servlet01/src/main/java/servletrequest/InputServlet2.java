package servletrequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 파라미터 name 을 모를 때  파라미터 name 값을 추출
 * getParameterNames()
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * request.getParameterNames() -> 파라미터 명을 enumeration 타입으로 반환
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration<String> enu = request.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value : values) {
				System.out.println("name = " + name + ", value = " + value);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
