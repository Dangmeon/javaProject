package exam.exception;

public class DivideArithmeticException extends Exception{
	
	public DivideArithmeticException() {}
	
	public DivideArithmeticException(String message) { // message 에 예외 원인이 전달됨
		super(message);
		
	} 

}
