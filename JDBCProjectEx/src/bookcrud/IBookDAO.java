package bookcrud;

import java.util.ArrayList;

public interface IBookDAO {
	
	public void insertBook(BookDTO dto);
	
	public ArrayList<BookDTO> getAllBook();
	
	public BookDTO detailBook(String bookNo);
	
	public void updateBook(BookDTO dto);
	
	public void deleteBook(String bookNo);
	
	public BookDTO searchBookName(String bookName);
	
	public ArrayList<BookDTO> searchPubName(String pubName);
	
	public ArrayList<BookDTO> searchBookAuthor(String bookAuthor);

}
