package anonymousex;

public class AnonymousMain {

	public static void main(String[] args) {
		// 익명 객체로 초기화된 클래스 필드 사용
		Anonymous anony = new Anonymous();
		
		// 익명 객체로 초기화된 필드를 통해 재정의된 메소드 호출
		anony.field.wake();
		// anony.field.work(); // The method work() is undefined for the type Person // 일반 메소드는 외부에서 사용 불가능(이유는? field 가 부모 클래스 타입)

		// 로컬변수가 익명자식객체로 값이 대입된 메소드 호출
		anony.method1();
		
		// 매개변수에 전달되는 파라미터의 값으로 Person 을 상속받는 익명자식객체 인스턴스를 전달
		anony.method2(new Person() {
			void study() {
				System.out.println("공부합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("8시 일어납니다.");
				study();
			}
		});

	}

}
