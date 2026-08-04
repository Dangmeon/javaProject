package nestedclass;

// 중첩된 클래스들도 클래스이므로 독립적인 바이트코드 파일(.class)로 생성됨
// 바깥 클래스
public class A {
	
	A(){
		System.out.println("A 객체가 생성됨"); // 셍성자 함수
	}
	
	/** 인스턴스 멤버 클래스 : 바깥 클래스 객체를 생성해야 접근(객체 생성) 가능 **/
	public class B{
		B(){
			System.out.println("B 객체가 생성됨");
		}
		int field1;
		void method1() {}
		// 정적 필드 메소드 선언 불가
		// static int field2;
		// static void method2() {}
	}
	
	
	/** 정적(static) 멤버 클래스 : 인스턴스 필그, 메소드 정적 필드, 메소드 모두 가능
	 *  바깥 클래스 객체 없이 C 클래스 객체 생성이 가능 -> 바깥 클래스명을 통해 생성 가능
	 *  **/
	static class C{
		C(){
			System.out.println("C 객체가 생성됨");
		}
		int field1;
		void method1() {}
		static int field2;
		static void method2() {}
		
	}
	
	
	/** 로컬(method 내부에 선언) 클래스 **/
	void method() {
		/** 로컬 클래스 : 인스턴스 필드와 메소드만 포함 가능 
		 * 메소드 호출 시점에 로컬 클래스는 메서드 저장 영역(메모리)에 JVM 에 의해 저장됨
		 * 로컬 클래스 삭제는 프로그램이 종료되면 삭제됨
		 * **/
		class D {
			D(){
				System.out.println("D 객체가 생성됨");
			}
			int field1;
			void method1() {};
		}
		D d = new D(); // 현 시점(메소드가 호출된)에서 생성 메소드 실행이 종료되면 제거됨
		d.field1 = 3;
		d.method1();
	} //메소드 호출이 종료되면 생성한 instance 는 제거됨, 참조를 중단 후 재사용 가능
	
	
	
	

}
