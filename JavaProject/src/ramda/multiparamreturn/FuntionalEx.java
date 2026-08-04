package ramda.multiparamreturn;

public class FuntionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현 객체 구성(람다식)
		
		IMyFunctionalInterface fi;
		// 매개변수 있고 반환문이 있는 추상메서드 구현하는 람다식
		fi = (int x, int y) -> {
			int res = x + y;
			return res;
		};
		fi.method(5, 6);
		
		// 매개변수 타입 생략 가능
		fi = (x, y) -> { 
			return x + y;
		};
		
		fi.method(5, 6);
		
		// 람다식 실행 블록이 return 한 줄 문장이면 중괄호와 return 생략 가능
		fi = (x, y) -> x + y;
		
		fi.method(5, 6);
		
		// 매개변수가 2개 이상인 경우 소괄호 필수
		fi = (x, y) -> x + y;
				
		fi.method(5, 6);

	}

}
