package classInfo;
import java.util.Scanner;

public class Rectangle {
	// 멤버 필드 초기화 가능
//	int width = 0;
//	int height = 0;
//	
	// Scanner sc = new Scanner(System.in); 멤버 필드 스캐너 객체, 동일 패키지 내 접근 사용 가능
	
	// 객체 외부 참조 불가능, 객체 내부에서만 참조가 가능(객체 메소드에서는 참조 가능)
	private int width = 0;
	private int height = 0;
	
	// 다른 클래스이 객체 변수 사용 가능
	Car c2 = new Car();
	
	
	
	// 멤버 메소드
	// 데이터 입력
	
	// 반환값 없음 - 입력만 받음
	public void input() {
		// 사용자로부터 정보 입력 받기
		Scanner sc = new Scanner(System.in); // 메소드 호출 시 생성
		
		System.out.print("가로 길이 입력 : ");
		width = sc.nextInt();
		
		System.out.print("세로 길이 입력 : ");
		height = sc.nextInt();
		
		sc.close(); // 메소드 종료 시 삭제

	}
	
	// 호출되면 필드값을 이용 사각형 면적 계산 후 출력
	public void area() {
		System.out.println("사각형 면적 : " + (width * height));
	}
	
	
	// car 클래스 데이터 입력 및 출력 메소드
	public void carInfo() {
		c2.carNo = "222라 4567";
		c2.showCarInfo();
	}

}
