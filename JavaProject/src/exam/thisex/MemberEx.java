package exam.thisex;
import java.util.Scanner;

public class MemberEx {

	public static void main(String[] args) { //프로그램 시작 시점
		// 프로그램의 시작과 끝(프로그램 처리 절차를 나열해야하는 메서드)
		Scanner sc = new Scanner(System.in);
		
		String id, name, hp, adress;
		int age;
		
		// 객체 생성시 필드 초기화
		// 생성자 호출 객체 생성시 m1 참조 객체인스턴스에 this 참조 생성됨
		Member m1 = new Member("hkd", "홍길동", 30, "010-1234-5678", "서울시 서대문구 연희동");
		m1.showMember();
		
		// sc.next() : 입력된 문자열 그대로 반환(첫번째 공백이 나올때까지의 문자열을 반환)
		System.out.println("------------------------------\n");
		System.out.print("아이디 입력 : ");
		id = sc.next();
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("나이 입력 : ");
		age = sc.nextInt();
		System.out.print("전화 입력 : ");
		hp = sc.next();
		System.out.print("주소 입력 : ");
		adress = sc.next();
		
		Member m2 = new Member(id, name, age, hp, adress);
		m2.showMember();
		
		sc.close();
		
	}// 프로그램 끝 시점

}
