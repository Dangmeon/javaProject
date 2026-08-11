package exam.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import jdbc.DBConn;

public class BookEx {

	public static void main(String[] args) {
		// book 테이블의 정보를 조회하는 프로그램
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		DBConn dbCon = new DBConn();
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;
		Scanner sc = new Scanner(System.in);
		
		try {
			con = dbCon.getConnection();
			
			// 총 도서 권수
			System.out.println("=================================================");
			System.out.println("1. 총 도서 수 조회");

			String query1 = "SELECT count(*) FROM book";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
				bookNo = rs.getString(1);

				System.out.println("총 도서 수 : " + bookNo + "권");
			}
			
			rs.close();
			stmt.close();
			
			System.out.println();
			System.out.println("=================================================");
			
			System.out.println("2. 년도 조회");
			System.out.print("조회할 기준 년도를 입력하세요 (YYYY) -> ");
			String inputYear = sc.nextLine();
			
			String query2 = "SELECT * FROM book WHERE TO_CHAR(bookDate, 'YYYY') = ?";
			pstmt = con.prepareStatement(query2);
			pstmt.setString(1, inputYear);
			rs = pstmt.executeQuery();
			
			System.out.println("----------------도서 정보 조회-------------------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일   \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bookDate1 = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate1, bookStock, pubNo);
			}
			
			rs.close();
			pstmt.close();
			
			System.out.println();
			System.out.println("=================================================");
			
			System.out.println("3. 저자 이름 조회");
			
			System.out.print("검색할 저자 이름 일부를 입력하세요 -> ");
			String inputAuthor = sc.nextLine();
			
			String query3 = "SELECT * FROM book WHERE bookAuthor LIKE ?";
			pstmt = con.prepareStatement(query3);
			pstmt.setString(1, "%" + inputAuthor + "%");
			rs = pstmt.executeQuery();
			
			System.out.println("----------------저자 정보 조회-------------------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일   \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bookDate1 = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate1, bookStock, pubNo);
			}
			
			rs.close();
			pstmt.close();
			
			System.out.println();
			System.out.println("=================================================");
			
			System.out.println("4. 가격 조건 조회");
			
			System.out.print("조회할 최소 기준 가격을 입력하세요 -> ");
			int inputPrice = sc.nextInt();

			String query4 = "SELECT * FROM book WHERE bookPrice >= ?";
			pstmt = con.prepareStatement(query4);
			pstmt.setInt(1, inputPrice);
			rs = pstmt.executeQuery();
			
			System.out.println("----------------가격 정보 조회-------------------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일   \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bookDate1 = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate1, bookStock, pubNo);
			}
			
			
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}

	}

}
