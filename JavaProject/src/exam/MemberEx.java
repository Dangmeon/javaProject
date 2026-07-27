package exam;
import java.util.Scanner;

public class MemberEx {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		Member newMem = new Member();
		
		newMem.showMember();
		
		System.out.print("---------------------------------------\n");
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("성명 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("전화번호 입력 : ");
		String phoneNo = sc.next();
		System.out.print("주소 입력 : ");
		String address = sc.next();
		
		Member newMem2 = new Member(id, name, age, phoneNo, address);
		newMem2.showMember();

		
	}

}
