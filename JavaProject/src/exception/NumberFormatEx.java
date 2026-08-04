package exception;

public class NumberFormatEx {

	public static void main(String[] args) {
		// 문자열을 숫자로 변환할 때 발생하는 에외
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1); // NumberFormatException
		int value2 = Integer.parseInt(data2);

		System.out.println();
	}

}
