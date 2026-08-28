package exam.binding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet("/prdView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ArrayList<ProductVo> prdList = (ArrayList<ProductVo>)request.getAttribute("prdList");
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='skyblue'>");
		out.print("<td>상품 번호</td><td>상품명</td><td>가격</td><td>재고</td><td>삭제</td></tr>");
		
		for(int i = 0; i < prdList.size(); i++) {
			ProductVo vo = prdList.get(i);
			String prdNo = vo.getPrdNo();
			String name = vo.getName();
			int price = vo.getPrice();
			int stock = vo.getStock();
			
			// 한 행씩 테이블에 포함
			out.print("<tr><td>" + prdNo + "</td><td>" + 
												name + "</td><td>" + 
												price + "</td><td>" +
												stock + "</td><td>" + 
												"<a href='/Servlet01/memberDelete?id=" + prdNo + "'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
	}
}
