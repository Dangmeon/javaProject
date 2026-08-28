package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
        System.out.println("===== 회원가입 폼 전달 데이터 =====");
        System.out.println("성명: " + stName);
        System.out.println("ID: " + stId);
        System.out.println("비밀번호: " + stPw);
        System.out.println("휴대폰 번호: " + fullPhone);
        System.out.println("학년: " + grade + "학년");
        System.out.println("학과: " + study);
        
        System.out.print("관심분야: ");
        if (interests != null) {
            for(String its : interests) {
                System.out.print(its + " ");
            }
            System.out.println();
        } else {
            System.out.println("선택 안 함");
        }

	}

}
