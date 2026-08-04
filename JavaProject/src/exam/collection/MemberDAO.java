package exam.collection;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements IMemberDAO{

	private List<MemberDTO> listData = new ArrayList<>(); // 회원 정보 저장소로 활용
	
	@Override
	public void insertMember(MemberDTO dto) {
		// 회원가입로직 : 동일 id 가 있는 지 확ㅇ니해서 있으면 회원가입 불가, 없으면 회원가입 진행
		// 가입할 회원의 id 추출
		String tmpId = dto.getMemId();
		
		// 회원 정보가 저장된 listData 의 원소들 중 memId 값이 tmpId 와 동일한 원소가 있는지 확인
		// 해당 원소있으면 반환, 없으면 null 반환
		// List.stream() : 컬렉션에 저장된 엘리먼트를 하나씩 순회하면서 뒤 연산을 진행해주는 코드 패턴
		// Stream<T> 타입을 반환
		// 동일 id 가 있으면 dto 객체 반환, 없으면 null
		MemberDTO optDto = listData.stream().filter(member -> member.getMemId().equals(tmpId))
				.findFirst().orElse(null);
		if(optDto != null) {
			System.out.println("회원 가입 실패 : 동일 id 의 회원이 있습니다.");
		}else {
			listData.add(dto);
			System.out.println("회원 가입 성공");
		}
	}

	@Override
	public void deleteMember(String memId) {
		
		MemberDTO optDto = searchMember(memId);
		if(optDto != null) {
			listData.remove(optDto);
			System.out.println("회원정보가 영구 삭제되었습니다.");
		}else {
			System.out.println("삭제할 ID가 없습니다.");
		}
		
	}

	@Override
	public ArrayList<MemberDTO> getAllMember() {
		
		if(listData.isEmpty()) {
			return null;
		}
		
		return new ArrayList<>(listData);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		
		MemberDTO optDto = searchMember(dto.getMemId());
		if(optDto != null) {
			optDto.setMemPass(dto.getMemPass());
			optDto.setMemName(dto.getMemName());
			optDto.setMemPhone(dto.getMemPhone());
			optDto.setMemAddress(dto.getMemAddress());
		}else {
			System.out.println("수정할 ID가 없습니다.");
		}
		
	}

	@Override
	public MemberDTO searchMember(String memId) {
		return listData.stream()
				.filter(member -> member.getMemId().equals(memId))
				.findFirst()
				.orElse(null);
	}
	

}
