package ramda.noparamnoreturn;

public class FuntionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현 객체 구성(람다식)
		
		IMyFunctionalInterface fi;
		// 매개변수 없고 반환문없는 람다식, 매개변수가 없으면 반드시 빈 괄호 필요, 실행 문자 2문장 이상
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> {
			System.out.println("method call2");
		};
		
		fi.method();
		
		// 람다식 실행 블록이 한 줄 문장이면 중괄호 생략 가능
		fi = () -> System.out.println("method call3");

		fi.method();

	}

}
