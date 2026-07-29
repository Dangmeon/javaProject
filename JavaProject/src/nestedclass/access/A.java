package nestedclass.access;

public class A {
	// 인스턴스 필드 선언 및 인스턴스 초기화
	// 중첩된 클래스 타입의 인스턴스 필드 선언 및 생성시 제약 없음
	B field1 = new B();
	C field2 = new C();
	
	// 인스턴스 메서드 내에서 중첩 클래스의 초기화(객체 생성) 가능
	void method1() {
		B var1 = new B();
		C var2 = new C();
	} /** 인스턴스 필드와 메소드에서는 중첨된 클래스(인스턴스 멤버, 정적 멤버)에 대한 참조 및 생성이 가능 **/
	
	// 정적 필드 선언 및 초기화 : 멤버 클래스를 이용(정적 멤버 클래스만 인스턴스 생성 초기화 가능)
	// No enclosing instance of type A is accessible. Must qualify the allocation with an enclosing instance of type A 
	// (e.g. x.new A() where x is an instance of A).
	// static B filed3 = new B();
	static C field4 = new C();
	
	
	// 정적 메소드내에서 멤버 클래스 참조 변수 선언 및 초기화
	static void method2() {
		// B var1 = new B(); // No enclosing instance of type A is accessible. 오류
		C var2 = new C(); // 클래스 이름으로 접근 가능
	}
	
	// 인스턴스 멤버 클래스
	class B{}
	
	// 정적 멤버 클래스
	static class C{}
	
}
