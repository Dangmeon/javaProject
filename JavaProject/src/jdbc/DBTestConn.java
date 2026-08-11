package jdbc;

// 1. 필요 패키지 import, DB 연결 관련 모든 기능 java.sql 패키지에 있음
import java.sql.Connection; // DB 연결 관련 인터페이스
import java.sql.DriverManager; // Connection 구현 객체 반환해줌

public class DBTestConn {

	public static void main(String[] args) {
		// DB 연결 test
		Connection con =  null;
		
		// 외부 자원 활용 : try ~ catch 구문 안에서 진행되거나 throws 문을 추가하거나
		try {
			// DB 연결과 관련된 코드
			// 1. JDBC DRIVER 클래스의 객체 생성 : 런타임시 JDBC 드라이버 로드(자동 로드 : 생략 가능)
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 접속 변수 생성
			// "oracle 접속 종류:@dbms주소(도메인, ip):포트:sid 또는 포트/서비스 name
			String url = "jdbc:oracle:thin:@localhost:29889/freepdb1";
			String user = "sql_select";
			String pwd = "1234";
			
			// 2. Connection interface 참조 변수에 구현 객체 대입(DB 접속 후 접속 객체 반환) -> DriverManager
			con = DriverManager.getConnection(url, user, pwd);
			
			// DB 접속 실패하면 catch, 저장값은 null
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(con != null) {
			System.out.println("DB 연결 성공");
		}else {
			System.out.println("DB 연결 실패");
		}
		// con.close(); throws 문 필요
		
	}

}
