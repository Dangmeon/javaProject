// jquery 활용 코드
$(document).ready(function() {
    $('#prdCheckBtn').on('click', function(event) {

        event.preventDefault();

        let prdNo = $('#prdNo').val();

        if (prdNo == "") {
            alert("상품번호를 입력하세요");
            return
        } else {
            // axios 기능 활용해서 비동기통신 진행 : is lib 및 스프링에 의존객테 필요
            axios.get("/mybatis/product/prdNoCheck5/" + prdNo)
            .then(function(response){
            	console.log(response);
            	if(response.data=="avaliable"){
            		alert("사용가능한 번호입니다.5")
            	}else{
            		alert("사용불가능한 번호입니다.5")
            	}
            })
            .catch(err => console.log(err));
        } // else 끝




    }); // on 끝 
}); // ready 끝