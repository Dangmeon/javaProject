package exam.book_interface;

import java.util.ArrayList;

public class BookDAO implements IBookDAO{

	@Override
	public void insertBook(BookDTO dto) {
		System.out.println("도서 등록 완료: " + dto.toString());
		
	}

	@Override
	public ArrayList<BookDTO> getAllBook() {
		ArrayList<BookDTO> list = new ArrayList<>();
		
		return list;
	}

	@Override
	public void deleteBook(String bookId) {
		System.out.println("도서 삭제 완료 (ID: " + bookId + ")");
		
	}

	@Override
	public void updateBook(BookDTO dto) {
		System.out.println("도서 정보 수정 완료: " + dto.toString());
		
	}

	@Override
	public BookDTO searchAuthor(String bookAuthor) {
		System.out.println("작가 검색 (작가명: " + bookAuthor + ")");
		
		BookDTO AuthorBook = new BookDTO();
		
		return AuthorBook;	
	}

	
}
