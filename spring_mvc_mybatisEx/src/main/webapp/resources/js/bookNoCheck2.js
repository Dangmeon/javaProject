$(document).ready(function(){
	$('#bookNoCheckBtn2').on('click', function(event){
		event.preventDefault();
		
		let bookNo=$('#bookNo').val();
		
		if(bookNo == ""){
			alert("상품 번호를 입력하세요");
			return false;
		}else{
			fetch("/mybatisEx/book/bookNoCheck2", {
			 	method: 'POST',
                headers: {
                    'Content-type': 'application/json'
                },
                body: bookNo
			})
				.then(response => response.text())
				.then(result => {
					if(result == "available"){
						alert("사용가능한 번호입니다. 2");
					}else{
						alert("사용불가능한 번호입니다. 2");
					}
				})
				.catch(err => console.log(err));
		} //else 끝
	}); // on 끝
}); //ready 끝