package ex1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductMain {

	public static void main(String[] args) {
		
		PrdJDBCConn PJcon = new PrdJDBCConn();
		Connection con = PJcon.getPrdJDBCConn();
		Statement stmt = null;
		ResultSet rs = null;
		
		if(con == null) {
			System.out.println("DB 연결 실패");
			
		}else {
			System.out.println("DB 연결 성공");
			
			try {
				
				String query = "SELECT * FROM productfin";
				stmt = con.createStatement();
				
				rs = stmt.executeQuery(query);
				
				System.out.println("DB 정보 출력");
				System.out.println("상품번호 \t 상품이름 \t\t\t\t 상품가격 \t\t 제조사 \t\t 색상 \t 번호"
						+ "");

				
				while(rs.next()) {
					String prdNo = rs.getString(1);
					String prdName = rs.getString(2);
					int prdPrice = rs.getInt(3);
					String prdMaker = rs.getString(4);
					String prdColor = rs.getString(5);
					String ctgNo = rs.getString(6);
					
					System.out.format("%-10s\t %-20s\t %-10d %13s \t%10s %10s\n",
							prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
				}
				
				rs.close();
				stmt.close();
				con.close();
				
			}catch(Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
			}
		}
		

	}

}
