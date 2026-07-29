package exam.book_interface;

public class BookDTO {
	
	private String bookId;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	
	public BookDTO() {
		
	}
	
	public BookDTO(String bookId, String bookName, String bookAuthor, int bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}
	

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookYear() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	@Override
    public String toString() {
        return "ID=" + bookId + ", 제목=" + bookName + ", 작가=" + bookAuthor + ", 가격=" + bookPrice;
    }
	
	

}
