/*
	axios 를 활용한 post 방식의 비동기청 처리 스크립트
	javascript 기능을 활용 
*/

window.onload = function(){
	
	let prdCheckBtn = document.getElementById('prdCheckBtn');
	
	prdCheckBtn.addEventListener('click', (event) => {
		event.preventDefault();
		let prdNo = document.getElementById('prdNo').value;
		
		if(prdNo == ""){
			alert("상품번호를 입력하세요");
		}else{
			// axios 의 post 방식으로 요청시 data의 전달은 json 방식의 데이터를 구성해서 전달
			let data = {"prdNo":prdNo};
			// post 방식의 data전달은 header를 통해 전달
			axios.post("/mybatis/product/prdNoCheck6", data)
				.then(function(response){
					if(response.data == "avaliable"){
						alert("사용가능한 번호입니다. 6");
					}else{
						alert("사용불가능한 번호입니다. 6");
					}
				})
				.catch((error) => {
					console.log(error.response);
				})
		}
	});
}