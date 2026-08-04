package exception.thorowex;

public class BalanceInsufficientException extends Exception{
	
	public BalanceInsufficientException() {} // 기본 생성자
	// 예외 처리 클래스 생성 시 예외 발생 원인(예외 메세지)을 전달하기 위해 String 타입 매개변수를 갖는 생성자를 구현함

	
	public BalanceInsufficientException(String message) { // message 에 예외 원인이 전달됨
		super(message);
		
		
	} 
}
// 예외 처리 클래스 내부에 필드 메서드 생성자 포함 가능
// 단, 대부분 생성자만 오버로딩한다.

// 예외 메세지 용도 : catch 에서 처리할 때 사용하기 위해