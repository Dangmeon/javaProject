package extendsex;

class SuperClass{
	int x;
	int y;
	
	public SuperClass() {
		x = 5;
		y = 10;
	}
}

// SuperClass 의 필드가 default 이므로 동일 패키지 클래스인 sub 에소는 필드 모두 사용 가능(상속)
class SubClass extends SuperClass{
	int x;
	
	public SubClass() {
		x = 10;
	}
	
	public void show() {
		System.out.println(x); // SubClass 에 x 필드가 있음 : SubClass 의 x 가 출력
		System.out.println(y); // SubClass 에 y 필드가 없음 : SuperClass 의 y 가 출력
		
		// super 클래스이 x 출력
		System.out.println("super의 x : "  + super.x); // Super 와 Sub 가 필드명이 중복되는 경우 Super 가 포함하는 필드를 의미
		System.out.println("sub의 x : "  + this.x);  // Sub 클래스의 x 필드를 명시적으로 표현
		System.out.print("super의 y : "  + super.y);
	}
}

public class SuperEx {

	public static void main(String[] args) {
		// super this 활용 예시

		SubClass sc = new SubClass();
		sc.show();
	}

}
