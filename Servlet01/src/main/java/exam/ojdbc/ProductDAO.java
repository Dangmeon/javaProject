package exam.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ProductDAO {

	public static Connection getConnection() {
		
		Connection con = null;

		try {
			// 메모리 로딩 코드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:29889/freepdb1";
			String user = "sql_select";
			String pwd = "1234";

			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// 데이터베이스의 product 테이블을 조회해서 모든 데이터를 자바의 리스트 담아 리턴
	public ArrayList<ProductVo> productSelect() {
		// PreparedStatement :  데이터베이스에 보낼 SQL 쿼리문을 임시로 담고 실행하는 명령서 송신 도구
		// ResultSet : 데이터베이스가 쿼리를 실행한 후 던져준 표 형태의 데이터 결과물을 보관
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<ProductVo> prdList = new ArrayList<>();

		try {
			con = getConnection();
			String query = "select * from product";
			pstmt = con.prepareStatement(query);
			// 명령서를 오라클로 쏘아 올려 실행하고 오라클이 보내준 결과 데이터를 rs 에 받아옴
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String no = rs.getString("prdNo");
				String name = rs.getString("prdName");
				int price = rs.getInt("prdPrice");
				int stock = rs.getInt("prdStock");
				Date joinDate = rs.getDate("prdJoinDate");

				ProductVo vo = new ProductVo();
				vo.setPrdNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setStock(stock);
				vo.setJoinDate(joinDate);

				prdList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return prdList;
	}

}
