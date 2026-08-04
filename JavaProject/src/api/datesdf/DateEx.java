package api.datesdf;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);

		// 생성자에 날짜 data 의 형식 포맷을 문자열로 전달 가능
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); 
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);

		
		
		
		
		
		
		System.out.println();

		

	}

}
