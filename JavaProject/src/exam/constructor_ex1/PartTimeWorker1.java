package exam.constructor_ex1;

public class PartTimeWorker1 {

	public static void main(String[] args) {
		
		PartTime pt = new PartTime("990101-1034567", "홍길동" , 60, 6000);
		
		System.out.println(pt); // 객체의 toString() 자동 호출
		
	}

}
