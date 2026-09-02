package secure.injection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	public Connection getConnection() {
		// DB 연결 test
		Connection con = null;

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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	
}
