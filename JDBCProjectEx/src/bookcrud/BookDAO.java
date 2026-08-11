package bookcrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements IBookDAO{
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BookDTO book = null;
	ArrayList<BookDTO> bookList = null;
	
	public BookDAO() {
		con = DBConn.getConnection();
	}

	@Override
	public void insertBook(BookDTO dto) {
		
		try {
			String sql = "insert into book values(?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBookNo());
			pstmt.setString(2, dto.getBookName());
			pstmt.setString(3, dto.getBookAuthor());
			pstmt.setInt(4, dto.getBookPrice());
			pstmt.setDate(5, new java.sql.Date(dto.getBookDate().getTime()));
			pstmt.setInt(6, dto.getBookStock());
			pstmt.setString(7, dto.getPubNo());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("도서 등록 성공");
			}else {
				System.out.println("도서 등록 실패");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt);
		}
		
	}

	@Override
	public ArrayList<BookDTO> getAllBook() {
		bookList = new ArrayList<BookDTO>();
		try {
			String sql = "select * from book order by bookNo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				// rs -> DTO -> ArrayList에 추가
				book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
				bookList.add(book);
			}
			
		}catch(SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt, rs);
		}
		
		
		return bookList;
	}
	

	@Override
	public BookDTO detailBook(String bookNo) {
		try {
			String sql = "select * from book where bookNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 한 개 레코드 반환
				bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
			}else {
				book = null;
			}
			
		}catch(SQLException e){
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt, rs);
		}
		
		return book;
	}

	@Override
	public void updateBook(BookDTO dto) {
		
		try {
			String sql = "update book set bookName=?, bookAuthor=?,"
					+ "bookPrice=?, bookDate=?, bookStock=?, pubNo=? where bookNo=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(7, dto.getBookNo());
			pstmt.setString(1, dto.getBookName());
			pstmt.setString(2, dto.getBookAuthor());
			pstmt.setInt(3, dto.getBookPrice());
			pstmt.setDate(4, new java.sql.Date(dto.getBookDate().getTime()));
			pstmt.setInt(5, dto.getBookStock());
			pstmt.setString(6, dto.getPubNo());
			
			pstmt.executeUpdate();
			
			System.out.println("정보 수정 성공");
			
		}catch(SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt);
		}
		
	}

	@Override
	public void deleteBook(String bookNo) {
		
		try {
			String sql = "delete from book where bookNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			
			pstmt.executeUpdate();
			
			System.out.println(bookNo + "도서 정보 삭제 성공");
			
		}catch(SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt);
		}
		
	}

	@Override
	public BookDTO searchBookName(String bookName) {
		try {
			String sql = "select * from book where bookName=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 한 개 레코드 반환
				String bookNo = rs.getString(1);
				bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
			}else {
				book = null;
			}
			
		}catch(SQLException e){
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt, rs);
		}
		
		return book;
	}

	@Override
	public ArrayList<BookDTO> searchPubName(String pubName) {
		
		try {
			String sql = "select * from book where pubNo IN("
					+ "select pubNo from publisher where pubName=?"
					+ ")";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pubName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				// rs -> DTO -> ArrayList에 추가
				book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
				bookList.add(book);
			}
			
		}catch(SQLException e){
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt, rs);
		}
		
		return bookList;
	}

	@Override
	public ArrayList<BookDTO> searchBookAuthor(String bookAuthor) {
		try {
			String sql = "select * from book where bookAuthor=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookAuthor);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				// rs -> DTO -> ArrayList에 추가
				book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
				bookList.add(book);
			}
			
		}catch(SQLException e){
			System.out.println("오류 발생");
			e.printStackTrace();
		}finally {
			DBConn.close(pstmt, rs);
		}
		
		return bookList;
	}

	
}
