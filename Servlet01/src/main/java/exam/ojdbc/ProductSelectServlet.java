package exam.ojdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductSelectServlet
 */
@WebServlet("/prdselect")
public class ProductSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  데이터베이스 ProductDAO 객체를 만들고, productSelect() 데이터를 요청
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVo> prdList = dao.productSelect();
		
		// DB에서 가져온 목록 데이터를 화면(JSP)까지 들고 가기 위해 request 라는 임시 바구니에 보관
		request.setAttribute("prdList", prdList);
		
		// 데이터 바구니(request)와 응답 문서(response)를 가지고 다음 목적지 주소(prdView2)로 포워드하라는 명령
		RequestDispatcher dispatch = request.getRequestDispatcher("prdView2");
		dispatch.forward(request, response);
	}

}
