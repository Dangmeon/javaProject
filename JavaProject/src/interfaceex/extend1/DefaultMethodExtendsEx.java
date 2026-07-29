package interfaceex.extend1;

public class DefaultMethodExtendsEx {

	public static void main(String[] args) {
		// 익명 구현객체 사용 - 일회성 클래스
		// ChildInterface1 을 익명 객체로 구현
		ChildInterface1 ci1 = new ChildInterface1() {

			@Override
			public void method1() {
				System.out.println("c1-m1()");
			}

			@Override
			public void method3() {
				System.out.println("c1-m3()");				
			}
			
			// ParentInterface 에서 상속되어진 default method 도 포함되게 됨
			
		};
		
		ci1.method1();
		ci1.method2(); // 디폴트 메소드 상속받음
		ci1.method3();
		
		// ChildInterface2 (디폴트 메서드 재정의) 를 구현하는 익명 객체
		ChildInterface2 ci2 = new ChildInterface2() {

			@Override
			public void method1() {
				System.out.println("c2-m1()");				
				
			}

			@Override
			public void method3() {
				System.out.println("c2-m3()");				
			}
			
			// ChildInterface2 의 재정의된 default 메소드 포함
			
		};
		
		ci2.method1();
		ci2.method2(); //  ChildInterface2 의 재정의된 default 메소드
		ci2.method3();
		
		// ChildInterface3(default 메소드 추상 메소드로 재선언)를 구현하는 익명 객체
		ChildInterface3 ci3 = new ChildInterface3() {

			@Override
			public void method1() {
				System.out.println("c3-m1()");
			}

			@Override
			public void method2() { // 부모 인터페이스에서는 default 였지만, 상속받아 추상으로 재선언
				System.out.println("c3-m2()"); 
				
			}

			@Override
			public void method3() {
				System.out.println("c3-m3()");
				
			}
			
		};
		
		ci3.method1();
		ci3.method2();
		ci3.method3();
		
	}

}
