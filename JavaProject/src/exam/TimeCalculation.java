package exam;
import java.util.Scanner;

public class TimeCalculation {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int hour, minute, second;
		
		System.out.print("시간 입력 (초) : ");
		int totalSecond = sc.nextInt();
		
		hour = totalSecond / 3600;
		minute = (totalSecond % 3600) / 60;
		second = totalSecond % 60;

		System.out.println(totalSecond + "초는 " + hour + "시간, " + minute + "분, " + second + "초입니다.");
	}

}
