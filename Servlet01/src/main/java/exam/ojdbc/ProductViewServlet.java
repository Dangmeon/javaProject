package exam.ojdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet(name = "ProductViewServlet2", urlPatterns = { "/prdView2" })
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 앞의 서블릿이 request 바구니에 "prdList"라는 이름으로 담아두었던 데이터를 꺼내어 변수에 담는 코드
		ArrayList<ProductVo> prdList = (ArrayList<ProductVo>) request.getAttribute("prdList");

		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>상품 번호</td><td>상품명</td><td>가격</td><td>재고</td><td>등록일</td><td>삭제</td></tr>");

		for (int i = 0; i < prdList.size(); i++) {
			ProductVo vo = prdList.get(i);
			String no = vo.getPrdNo();
			String name = vo.getName();
			int price = vo.getPrice();
			int stock = vo.getStock();
			Date joinDate = vo.getJoinDate();

			out.print("<tr><td>" + no + "</td><td>" + 
												name + "</td><td>" + 
												price + "</td><td>" + 
												stock + "</td><td>" +
												joinDate + "</td><td>"
												+ "<a href='/Servlet01/memberDelete?id=" + no + "'>삭제</a></td></tr>");
		}

		out.print("</table></body></html>");
		out.close();

	}

}
