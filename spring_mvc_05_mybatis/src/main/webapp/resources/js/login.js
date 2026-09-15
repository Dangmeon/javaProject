$(document).ready(function(){
	
	$('#frmLogin').on('submit', function(){
		event.preventDefault(); // submit 이벤트 중기
		
		// 서버로 요청할 때 전송할 data 준비
		let user_id = $('#user_id').val();
		let user_pw = $('#user_pw').val();
	
		$.ajax({
				// 비동기 요청에 대한 요청 정보 나열 k : v
				type:"post", // 메소드
				url:"/mybatis/login", // 요청 url
				data:{"id":user_id, "pw":user_pw}, // 클라이언트가 서버로 전송할 파라미터(payload)
				dataType:'text', // 서버로부터 반환받을 data의 타입
				// 요청에 대한 응답 데이터 처리 - success 처리 함수의 매개변수로 전달
				success:function(result){
					if(result=="success")
						message="로그인 성공";
					else
						message="로그인 실패";
					alert(message);
				},
				error:function()
				{
					alert("전송 실패");
				}, 
				complete:function(){
				
				}
			 }); // ajax 끝
			 
	}); // on 끝

}); // ready 끝