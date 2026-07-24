package classInfo;

public class Calculator {
	// 메서드 구성 (클래스 포함)
	// 접근제한자 생략 : protected (동일 패키지내에서 접근 가능)
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double divide(int x, int y) {
		return (double) x / (double) y;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	// 클래스에 포함되지 않고 메소드 독립적으로 jvm 에 의해 처리
	// main 을 포함하고 있는 클래스의 객체 생성 가능
	public static void main(String[] args) {
		Calculator myClac = new Calculator();
		myClac.powerOn();
		
		int result1 = myClac.plus(5, 6);
		System.out.println("result1 : " + result1);
		
		byte x = 10; byte y = 4;
		double result2 = myClac.divide(x, y);
		System.out.println("result2 : " + result2);

		
		myClac.powerOff();
	}

}
