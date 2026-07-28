package exam.instarray;

public class CourseMain {

	public static void main(String[] args) {
		Course[] c = new Course[3];
		
		System.out.print("**** 과목 정보 입력 ****\n");
		
		for(int i = 0; i < c.length; i++) {
			c[i] = new Course();
			c[i].input();
		}
		
		System.out.print("**** 과목 정보 출력 ****\n");
		
		for(int i = 0; i < c.length; i++) {
			c[i].output();
		}

	}

}
