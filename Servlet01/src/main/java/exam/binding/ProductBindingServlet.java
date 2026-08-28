package exam.binding;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prdBinding")
public class ProductBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProductVo vo1 = new ProductVo("1000", "감자", 1000, 10);
		ProductVo vo2 = new ProductVo("1001", "고구마", 2000, 20);
		ProductVo vo3 = new ProductVo("1002", "배추", 3000, 30);
		
		ArrayList<ProductVo> prdList = new ArrayList<>();
		prdList.add(vo1);
		prdList.add(vo2);
		prdList.add(vo3);
		
		request.setAttribute("prdList", prdList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("prdView");
		dispatch.forward(request, response);
	}

}
