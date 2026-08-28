package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinResServlet
 */
@WebServlet("/JoinResServlet")
public class JoinResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get 요청");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post 요청");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess 요청");

		request.setCharacterEncoding("utf-8");
		String stName = request.getParameter("stName");
		String stId = request.getParameter("stId");
		String stPw = request.getParameter("stPw");

		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String fullPhone = phone1 + "-" + phone2 + "-" + phone3;

		String grade = request.getParameter("grade");
		String study = request.getParameter("study");

		String[] interests = request.getParameterValues("interest");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head></head><body>");
		out.println("<h2>회원가입 내용</h2>");
		out.println("성명 : " + stName + "<br>");
		out.println("ID : " + stId + "<br>");
		out.println("비밀번호 : " + stPw + "<br>");
		out.println("휴대폰번호 : " + fullPhone + "<br>");
		out.println("학년 : " + grade + "<br>");
		
		out.print("관심분야 : ");
        if(interests != null) {
        	for(String its : interests) {
        		out.print(its + " " + "<br>");
        	}
        } else {
            out.println("선택 안 함<br>");
        }
		out.println("학과 : " + study + "<br>");

		out.println("</body></html>");

	}

}
