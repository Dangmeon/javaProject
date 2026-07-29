package exam.book_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		BookDTO bto = null;
		
		System.out.println("북 정보 입력");
		System.out.print("id 입력 : "); String id = sc.next();
		System.out.print("제목 입력 : "); String title = sc.next();
		System.out.print("작가 입력 : "); String author = sc.next();
		System.out.print("가격 입력 : "); int price = sc.nextInt();
		
		bto = new BookDTO(id, title, author, price);
		
		IBookDAO dao = new BookDAO();
		
		dao.insertBook(bto);
				
		ArrayList<BookDTO> bookList = dao.getAllBook();
		
		bto.setBookPrice(price + 1000);
		dao.updateBook(bto);
				
		dao.searchAuthor(author);
				
		dao.deleteBook(id);
		
	}

}
