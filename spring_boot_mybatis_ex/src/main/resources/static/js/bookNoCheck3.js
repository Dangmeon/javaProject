$(document).ready(function(){
	$('#bookNoCheckBtn3').on('click', function(event){
		event.preventDefault();
		
		let bookNo=$('#bookNo').val();
		
		if(bookNo == ""){
			alert("상품 번호를 입력하세요");
			return false;
		}else{
			let data = {"bookNo":bookNo};

			axios.post("/book/bookNoCheck3", data)
				.then(function(response){
					if(response.data == "available"){
						alert("사용가능한 번호입니다. 3");
					}else{
						alert("사용가불능한 번호입니다. 3");
					}
				})
				.catch((error) => {
					console.log(error.response);
				})
		} //else 끝
	}); // on 끝
}); //ready 끝