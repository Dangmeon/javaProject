package bookcrud;

import java.util.ArrayList;
import java.util.Scanner;


public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IBookDAO dao = new BookDAO();
		
		Scanner sc = new Scanner(System.in);
		String bookNo;
		String pubName;
		String selMenu = null;
		ArrayList<BookDTO> bookList = null;
		
		while(true) {
			try {
				System.out.println("===============학생관리 프로그램=============");
				System.out.println("1. 도서정보 등록");
				System.out.println("2. 도서정보 조회");
				System.out.println("3. 도서정보 수정");
				System.out.println("4. 도서정보 삭제");
				System.out.println("5. 도서정보 조회(도서명)");
				System.out.println("6. 도서정보 조회(출판사명)");
				System.out.println("7. 도서정보 조회(저자명)");
				System.out.println("8. 종료");
				System.out.println("========================================");

				System.out.print("메뉴 번호 입력 : ");
				selMenu = sc.nextLine();	
				
			}catch(Exception e){
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
				e.printStackTrace();
			}
			
			switch(selMenu) {
			case "1":
				dao.insertBook(ReadWrite.getBookInfo(sc, true));
				break;
			case "2":
				bookList = dao.getAllBook();
				ReadWrite.writeStdInfo(bookList);
				break;
			case "3":
				bookList = dao.getAllBook();
				ReadWrite.writeStdInfo(bookList);
				System.out.println("수정할 도서번호 입력 : ");
				bookNo = sc.nextLine();
				dao.updateBook(ReadWrite.getBookInfo(sc, false));
				break;
			case "4":
				bookList = dao.getAllBook();
				ReadWrite.writeStdInfo(bookList);
				System.out.println("삭제할 도서번호 입력 : ");
				bookNo = sc.nextLine();
				dao.deleteBook(bookNo);
				break;
			case "5":
				System.out.println("도서명을 입력하세요");
				dptName = sc.nextLine();
				ReadWrite.writeStdInfo(dao.searchStudentDept(dptName));
				break;
			case "6":
				System.out.println("출판사명을 입력하세요");
				dptName = sc.nextLine();
				ReadWrite.writeStdInfo(dao.searchStudentDept(dptName));
				break;
			case "7":
				System.out.println("저자명을 입력하세요");
				dptName = sc.nextLine();
				ReadWrite.writeStdInfo(dao.searchStudentDept(dptName));
				break;
			case "8":
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(0); // 프로그램 종료
			default :
				System.out.println("잘못된 입력입니다.");
				
			}
		}

	}

}
