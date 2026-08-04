package ramda.oneparamnoreturn;

public class FuntionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현 객체 구성(람다식)
		
		IMyFunctionalInterface fi;
		// 매개변수 없고 반환문없는 람다식, 실행 문자 2문장 이상
		fi = (int x) -> {
			int res = x * 5;
			System.out.println(res);
		};
		fi.method(5);
		
		fi = (x) -> { // 호출시 대입되는 파라미터로 타입을 유추
			int res = x * 5;
			System.out.println(res);
		};
		
		fi.method(5);
		
		// 람다식 매개변수가 1개면 소괄오 생략 가능 실행 블록이 한 줄 문장이면 중괄호 생략 가능
		fi = x -> System.out.println(x * 5);
		
		fi.method(5);

	}

}
