package exam;
import java.util.Scanner;

public class Member {
	
	Scanner sc = new Scanner(System.in);
	
	private String id;
	private String name;
	private int age;
	private String phoneNo;
	private String address;
	
	public Member() {
		this.id = "hkd";
		this.name = "홍길동";
		this.age = 30;
		this.phoneNo = "010-1234-5678";
		this.address = "서울시 강남구 대치동";
	}
	
    public Member(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNo = phone;
        this.address = address;
    }
    
    
	
	

}
