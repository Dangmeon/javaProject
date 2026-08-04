package exam.exception;


public class Divide {
	
	private int num1, num2;
	private int result;
	
	public Divide() {}
	
	public int getDivide() {
		return result;
	}
	
	public void divide(int num1, int num2) throws DivideArithmeticException{
		if(num1 == 0 || num2 == 0) {
			throw new DivideArithmeticException("0으로 나눌 수 없습니다.");
		}
		result = num1 / num2;
	}
	
}
