package exam.collection;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		//회원 관리 모듈 사용 예시
		
		// 회원 가입
		// 회원 가입을 위한 정보 입력 받기
		Scanner sc = new Scanner(System.in);
		IMemberDAO idao = new MemberDAO();
		
		MemberDTO dto = null;
//		IMemberDAO idao = null;
		
		while(true) {
            System.out.println("**** 1.회원가입 | 2.회원탈퇴 | 3.전체회원조회 | 4.개인회원조회 | 5.회원정보수정 | 6.종료 ****");
            System.out.println("메뉴를 선택하세요 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            
            if(menu == 6) {
            	System.out.println("회원 관리 프로그램을 종료합니다.");
            	break;
            }
			
			String id, pass, name, phone, address;
			
			switch(menu) {
			case 1:
				//회원등록
				//회원 정보 입력 받기
				System.out.println("회원정보를 입력합니다");
				System.out.println("id 입력 : "); id =sc.next();
				System.out.println("pass 입력 : "); pass =sc.next();
				System.out.println("이름 입력 : "); name =sc.next();
				System.out.println("전화번호 입력 : "); phone =sc.next();
				
				sc.nextLine();
				System.out.println("주소 입력 : "); address = sc.nextLine();

				
				//1. dto 객체 생성
				dto = new MemberDTO(id,pass,name,phone,address);
				idao.insertMember(dto);
				break;
				
			case 2:
				System.out.println("회원 정보를 삭제합니다.");
				System.out.println("id 입력 : ");
				id = sc.next();
				idao.deleteMember(id);
				break;
				
			case 3:
				ArrayList<MemberDTO> list = idao.getAllMember();
				System.out.println("전체 회원 정보를 조회합니다.");
				
				if(list == null || list.isEmpty()) {
					System.out.println("해당 id 정보가 없습니다.");
				}else {
					for(MemberDTO mem : list) {
						System.out.println(mem);
					}
				}
				break;
				
			case 4:
				System.out.println("회원 정보를 조회합니다.");
				System.out.println("id 입력 : ");
				id = sc.next();
				dto = idao.searchMember(id);
				
				if(dto != null) {
					System.out.println(dto);
				}else {
                    System.out.println("해당 id 정보가 없습니다.");
				}
				break;
				
			case 5:
				System.out.println("회원정보를 수정합니다.");
				System.out.println("수정 회원 id 입력 : ");
				id = sc.next();
				dto = idao.searchMember(id);
				
				if(dto != null) {
					System.out.println("기존 정보 출력");
					System.out.println(dto);
					
					System.out.println("pass 입력 : "); pass = sc.next();
                    System.out.println("이름 입력 : "); name = sc.next();
                    System.out.println("전화번호 입력 : "); phone = sc.next();
                    
        			sc.nextLine();
                    System.out.println("주소 입력 : "); address = sc.nextLine();
    	
    				
                    MemberDTO updateDto = new MemberDTO(id,pass,name,phone,address);
    				idao.updateMember(updateDto);
    				
					System.out.println("회원 정보 수정이 완료되었습니다.");

				}else {
                    System.out.println("해당 id의 회원이 없습니다.");
				}
				break;

			default :
				System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
			}

		}
		
		sc.close();
	


		
		/**
		// 1명 회원 정보 조회
		System.out.print("조회할 id 입력 : "); id = sc.next();
		memDto = dao.searchMember(id);
		if(!(memDto == null)) {
			System.out.println(memDto.getMemId());
			memDto.getMemPass();
			memDto.getMemName();
			memDto.getMemPhone();
			memDto.getMemAddress();
		}else {
			System.out.println(id + "에 해당하는 회원 정보는 조회되지 않습니다.");
		}
		**/


	}

}
