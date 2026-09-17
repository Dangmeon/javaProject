$(document).ready(function(){
	$('#bookNoCheckBtn1').on('click', function(event){
		event.preventDefault();
		
		let bookNo=$('#bookNo').val();
		
		if(bookNo == ""){
			alert("상품 번호를 입력하세요");
			return false;
		}else{
			// 서버로 상품번호 전달 중복 확인 진행
			$.ajax({
			 	type:"post",
			 	url:"/mybatisEx/book/bookNoCheck1",
				data:{"bookNo":bookNo},
				dataType:"text",
				success:function(result){
					if(result=="available"){
						alert("사용가능한 번호입니다.");
					}else{
						alert("사용불가능한 번호입니다.");						
					}
				},
				error:function(){
					alert("전송실패");
				},
				
			}); // ajax 끝
		} //else 끝
	}); // on 끝
}); //ready 끝