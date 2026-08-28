package servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet") // SecondServlet 클래스의 별명(servlet path) -> URI -> URL
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 객체 생성시 1번 호출
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() - SecondServlet 시작");
	}

	/**
	 * 코드 업데이트 또는 서버 종료시 1번 호출
	 */
	public void destroy() {
		System.out.println("destroy() - 자원 해제 완료 - 수정 test");
	}

	/**
	 * 클라이언트 Get method 요청이 있을 때마다 호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청을 처리 중입니다...");
	}

}
