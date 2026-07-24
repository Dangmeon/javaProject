package classInfo;

public class MainEx {

	public static void main(String[] args) {
		// 객체 변수 선언 및 인스턴스 생성
		Rectangle rec = new Rectangle();
		
		rec.input();
		rec.area();
		
		// 클래스의 접근제한자 생략되어 있으므로 필드 직접 접근 가능
		// rec.height = 80;
		// 클래스 필드의 접근제한자가 private 면 외부 접근이 불가능
		
		// 필요한 클래스 모두 사용 가능
		Car c1 = new Car();
		c1.carName = "아반떼";
		c1.carNo = "111가 1234";
		c1.showCarInfo();
		
		// rec 객체에 피요한 car 정보 메소드 호출
		rec.carInfo();
		
	}

}
