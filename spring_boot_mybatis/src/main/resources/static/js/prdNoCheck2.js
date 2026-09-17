$(document).ready(function(){
	$('#prdCheckBtn').on('click', function(){
		event.preventDefault();
		
		let prdNo=$('#prdNo').val();
		
		if(prdNo == ""){
			alert("상품 번호를 입력하세요");
			return false;
		}else{
			// 서버로 상품번호 전달 중복 확인 진행
			$.ajax({
			 	type:"get",
			 	url:"/product/prdNoCheck1/" + prdNo, // uri data 전송
			 	// url:"/mybatis/product/prdNoCheck?prdNo=" + prdNo, // 쿼리스트링 방식의 전송 // 잘 사용하지 않음
				data:{"prdNo":prdNo},
				dataType:"text",
				success:function(result){
					if(result=="avaliable"){
						alert("사용가능한 번호입니다. 1");
					}else{
						alert("사용불가능한 번호입니다. 1");						
					}
				},
				error:function(){
					alert("전송실패");
				},
				
			}); // ajax 끝
		} //else 끝
	}); // on 끝
}); //ready 끝