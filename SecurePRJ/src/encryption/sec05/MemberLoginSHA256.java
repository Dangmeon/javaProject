package encryption.sec05;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberLoginSHA256 {
	
	
// 로그인시 salt 값은 db 에 저장되어 있는 상태
// 회원정보와 동일 테이블에 저장되어 있으면 취약한 정보 저장임(단, 연습용이어서 동일 테이블에 저장했음)
// 로그인시에는 해시기능 메소드만 필요함(개발자는 회원가입시 진행한 스트레칭 수는 개발자는 알고 있음)
	
	// 비밀번호 해싱 : 키스트레칭 + salt
	public static String sha256(String password, String salt) throws Exception{ // 스츠레칭도 동시 실행되도록 구성
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		for(int i = 0; i < 10; i++) {
			password = password + salt;
			md.update(password.getBytes());
			password = bytesToHex(md.digest()); // byte 형 배열을 반환 -> 문자열로 변환 후 반복에서 재사용
		}
		return password;
	}
	
	// byte 형 배열 문자열로 변경 결합 (16진수로 변경 후 결합) -> 16진수로 변경하는 이유는 표현되는 값의 범위가 넓어지도록 16진수로 변경
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		DBConn dbCon = new DBConn();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		
		ResultSet rs = null; //select 구문
		
		Scanner sc = new Scanner(System.in);
		
		String dbPwd = null;
		String dbSalt = null;
		
		try {
			System.out.print("ID 입력 : ");
			String memID = sc.nextLine();
			System.out.print("비밀번호 입력 : ");
			String memPass = sc.nextLine();
			System.out.println(memPass);
			
			//select 쿼리문 작성 - 취약한 페이지(동적코드)
			String sql = "select * from member where memID = '" + memID + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			

			// 회원가입시 중복 아이디는 허용하지 않음
			// 위 쿼리의 결과는 레코드가 1개거나 아니면 없거나
			if(rs.next()) {
				dbPwd = rs.getString(2);
				dbSalt =rs.getString(6);
				String hasPass = sha256(memPass, dbSalt);
				if(dbPwd.equals(hasPass)) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패"); // id 는 존재하는데 비밀번호가 다름
				}
			}else {
				System.out.println("로그인 실패-해당 회원정보가 없습니다."); // id 가 존재하지 않는경우
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

// 취약페이지임을 확인
//ID 입력 : ' or 1=1 --
//비밀번호 입력 : 1234
//로그인 되었습니다.




//ID 입력 : memhgd
//비밀번호 입력 : 1234
//03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
//로그인 되었습니다.

//ID 입력 : memhgd
//비밀번호 입력 : 03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
//756bc47cb5215dc3329ca7e1f7be33a2dad68990bb94b76d90aa07f4e44a233a
//로그인 실패









