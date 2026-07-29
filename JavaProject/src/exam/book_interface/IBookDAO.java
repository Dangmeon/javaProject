package exam.book_interface;

import java.util.ArrayList;

public interface IBookDAO {
	
	// 책 등록
	public void insertBook(BookDTO dto);
	
	// 책 전체 조회
	public ArrayList<BookDTO> getAllBook();
	
	// 책 삭제
	public void deleteBook(String bookId);
	
	// 책 수정
	public void updateBook(BookDTO dto);
	
	// 책 작가 조회 
	public BookDTO searchAuthor(String bookAuthor);

}
