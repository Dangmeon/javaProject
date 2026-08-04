package exam.collection;

import java.util.ArrayList;

// 회원 관리 모듈 구성을 위해 interface 에서 회원 관리 기능을 정의
public interface IMemberDAO {
	
	public void insertMember(MemberDTO dto);
	
	public void deleteMember(String memId);
	
	public ArrayList<MemberDTO> getAllMember();
	
	public void updateMember(MemberDTO dto);

	public MemberDTO searchMember(String memId);

}
