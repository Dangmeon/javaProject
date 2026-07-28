package extendsex.abstractex;

public class Dog extends Animal{
	// 일반 메서드 재정의 (개발자 선택)
	@Override
	public void show() {
		System.out.println("강아지입니다.");
	}

	// 추상클래스 상속 받은 경우 추상 메서드는 반드시 구현해야함
	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}
