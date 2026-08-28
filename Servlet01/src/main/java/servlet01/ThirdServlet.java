package servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 * Get 방식의 요청(브라우저 주소 줄을 이용해 직접 주소 입력 요청)
 * 서블릿에 doGet() 포함되지 않으면 
 * 서블릿 객체가 생성됨 -> 요청 처리를 진행할 메소드가 없으므로 요청 처리 불가(응답 불가)
 * 웹 서버는 무조건 응답해야 하므로 응답 불가 상황에 대한 에러 페이지를 응답하게 됨
 * 
 * http://localhost:8080/Servlet01/third
 * 프로토콜://도메인:포트/context/컨텐츠 구별 URI/...
 *  context : 톰캣 입장에서는 한 개의 웹 어플리케이션으로 인식함
 *  고유하게 구별 가능한 이름
 *  context 가 web site 의 기능 하나를 의미하므로 기능을 잘 나타내는 명사를 이용해서 context 명 생성
 *  context 명은 server.xml 에 등록됨
 *  : 모든 설정정보를 xml 로 저장한 후 서버가 구동되면 해당 xml 정보를 읽어와서 서버에 설정을 진행
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Get 방식의 요청에는 호출되지 않는 메소드
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
