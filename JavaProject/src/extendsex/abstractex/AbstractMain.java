package extendsex.abstractex;

public class AbstractMain {

	public static void main(String[] args) {
		// 추상 클래스 활용 예시
		// 추상클래스는 독립적인 객체 인스턴스 생성 불가능
		// Animal  ani = new Animal(); // Cannot instantiate the type Animal
		
		Dog dd = new Dog();
		Cat cc = new Cat();
		
		dd.show(); // 재정의된 메서드 호출
		dd.sound(); // 추상 메서드가 구현된 메서드 출력
		
		// 추상클래스는 단독 객체 생성은 불가능하지만 서브클래스 객체 생성시에 닽이 생성됨
		cc.show(); // Cat 클래스에서는 show 메서드 재정의하지 않음, Animal 클래스이 일반 메서드 show 가 호출
		cc.sound(); // 추상 메서드가 구현된 메서드 출력
		
		// 추상 클래스 참조 변수에 서브클래스 인스턴스 대입이 가능한지 - 추상클래스도 다형성을 사용할 수 있음
		Animal ani = new Cat();
		ani.show();
		ani.sound();
		
		ani = new Dog();
		ani.show();
		ani.sound();
		
		// 추상클래스 참조 변수 강제 형변환 가능?
		if(ani instanceof Dog) {
			//Dog dd1 = ani; // Type mismatch: cannot convert from Animal to Dog
			Dog dd1 = (Dog)ani;
			System.out.println("Animal 추상클래스 참조변수가 강제 형변환");
		}else {
			System.out.println("Animal 추상클래스 참조변수가 강제 형변환 불가능");
		}
		
		
		
		
		
	}

}
