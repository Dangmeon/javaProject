package exam.forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFirst
 */
@WebServlet("/refresh01")
public class ServletFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
        String stName = request.getParameter("stName");
        String stId = request.getParameter("stId");
        String stPw = request.getParameter("stPw");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String grade = request.getParameter("grade");
        String study = request.getParameter("study");
        String[] interests = request.getParameterValues("interest");
        
        String safeName = (stName == null) ? "" : URLEncoder.encode(stName, "utf-8");
        String safeStudy = (study == null) ? "" : URLEncoder.encode(study, "utf-8");
        
        String url = "refresh02"
                + "?stName=" + safeName
                + "&stId=" + stId
                + "&stPw=" + stPw
                + "&phone1=" + phone1
                + "&phone2=" + phone2
                + "&phone3=" + phone3
                + "&grade=" + grade
                + "&study=" + safeStudy;
        
        if (interests != null) {
            for (String its : interests) {
                url += "&interest=" + URLEncoder.encode(its, "utf-8");
            }
        }
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("데이터를 분석 중입니다... 5초 뒤 결과 페이지로 이동합니다.");
		out.println("</body></html>");
		
		// Refresh 속성 : 시간(초);url=매핑이름
		response.addHeader("Refresh", "5;url=" + url);
		
		out.println("</body></html>");
	}

}
