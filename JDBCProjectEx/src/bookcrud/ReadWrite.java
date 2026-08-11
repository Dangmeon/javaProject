package bookcrud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
	
	public static BookDTO getBookInfo(Scanner sc, boolean isInsert) {
		BookDTO dto = null;
		String bookNo = null;

		try {

			System.out.println("도서 정보 등록");
			if (isInsert) {
				System.out.print("도서번호 입력: ");
				bookNo = sc.next();
				sc.nextLine();
			}

			System.out.print("도서명 입력 : ");
			String bookName = sc.nextLine();

			System.out.print("저자 입력 : ");
			String bookAuthor = sc.nextLine();

			System.out.print("가격 입력 : ");
			int bookPrice = sc.nextInt();
			sc.nextLine();
			
			System.out.print("발행일 입력 : ");
			String bookDate = sc.nextLine();
			// 입력한 문자열을 Date 타입으로 변환
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date bookD = fm.parse(bookDate);

			System.out.print("재고 입력 : ");
			int bookStock = sc.nextInt();
			sc.nextLine();
			
			System.out.print("출판사 번호 입력 : ");
			String pubNo = sc.nextLine();

			dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookD, bookStock, pubNo);

		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
		}
		return dto;

	}
	
	
	// 출력 메소드 - dao에서 select된 결과는 ArrayList 타입이거나 StudentDTO 타입
	public static void writeBookInfo(ArrayList<BookDTO> bookList)  {
		System.out.println("----- 도서 정보 조회 ------");
		System.out.format("%-10s\t %-15s\t %-10s\t %-8s \t%13s %5s %5s\n", 
				"도서번호", "도서명", "저자", "가격", "발행일", "재고", "출판사번호");	
		
		for(BookDTO dto : bookList) {
			String bookNo = dto.getBookNo();
			String bookName = dto.getBookName();
			String bookAuthor = dto.getBookAuthor();
			int bookPrice = dto.getBookPrice();
			Date bookDate = dto.getBookDate();
			int bookStock = dto.getBookStock();
			String pubNo = dto.getPubNo();
			
			// 한 행씩 출력 
			System.out.format("%-10s\t %-15s\t %-10s\t %-8d \t%13s %5d %5s\n", 
					bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
		}
	}
	
	public static void writeBookInfo(BookDTO dto)  {
		
		if (dto == null) {
	        System.out.println("검색 결과가 없습니다. (도서명을 다시 확인해 주세요.)");
	        return; 
	    }
		
		System.out.println("----- 도서 정보 조회 ------");
		System.out.format("%-10s\t %-15s\t %-10s\t %-8s \t%13s %5s %5s\n", 
				"도서번호", "도서명", "저자", "가격", "발행일", "재고", "출판사번호");

		String bookNo = dto.getBookNo();
		String bookName = dto.getBookName();
		String bookAuthor = dto.getBookAuthor();
		int bookPrice = dto.getBookPrice();
		Date bookDate = dto.getBookDate();
		int bookStock = dto.getBookStock();
		String pubNo = dto.getPubNo();

		// 한 행씩 출력
		System.out.format("%-10s\t %-15s\t %-10s\t %-8d \t%13s %5d %5s\n",
				bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);

	}
	

}
