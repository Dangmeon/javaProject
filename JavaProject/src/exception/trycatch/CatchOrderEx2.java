package exception.trycatch;

public class CatchOrderEx2 {

	public static void main(String[] args) {
		// catch 부분이 여러번 있을 때 catch 순서에 따라 상위 클래스가 먼저 나타나면 해당 catch 실행하고 나머지 catch 는 점프
		// 상위 클래스 처리가 하위클래스 catch 보다 먼저 나오면? 아래 catch 는 무용지물임
		// 상위 클래스(Exception) 처리 catch 는 가장 마지막에 놓는다.
		
		try {
			String data1 = args[0];
			String data2 = args[1];
			
			System.out.println("args[0]:"+data1);
			System.out.println("args[1]:"+data2);
			
		}catch(Exception e) { // 예외 처리 클래스 중 최상위 클래스이므로 어떤 예외던지 무조건 처리 아래 있는 다른 catch 는 필요없음
			System.out.println("실행에 문제가 있습니다.");

		}catch(ArrayIndexOutOfBoundsException e) { // Unreachable catch block for ArrayIndexOutOfBoundsException. It is already handled by the catch block for Exception
			System.out.println("실행 매개값의 수가 부족합니다.");
			
		}finally {
			System.out.println("다시 실행");
		}

	}

}
