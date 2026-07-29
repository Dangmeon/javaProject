package interfaceex.extend;

public class MutiExtendsInterfaceMain {

	public static void main(String[] args) {

		// 인터페이스 상속에서의 다형성
		
		// 구현 클래스 객체 생성
		ImplementationC c = new ImplementationC();
		
		// 인터페이스 팜조변수에 대입
		// InterfaceA 와 InterfaceB 는 동일 계층
		// InterfaceC 는 InterfaceA 와 InterfaceB를 상속했으므로 하위계층
		
		// 상위 인터페이스는 자신의 추상 메서드 구현에만 접근 가능
		InterfaceA ia = c;
		ia.methodA();
		// ia.methodB(); // The method methodB() is undefined for the type InterfaceA
	
		InterfaceB ib = c;
		ib.methodB();
		
		System.out.println("-----------------------------------------");
		// InterfaceA 와 InterfaceB를 상속 받음으로써 InterfaceC 참조변수는 상속받은 인터페이스 추상메소드
		// 자신 추상 메소드 구현체에 접근 가능
		InterfaceC ic = c;
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		c.methodA();
		c.methodB();
		c.methodC();

		
		
		
	}

}
