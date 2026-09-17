$(document).ready(function() {
    $('#prdCheckBtn').on('click', function(event) {

        event.preventDefault();

        let prdNo = $('#prdNo').val();

        if (prdNo == "") {
            alert("상품번호를 입력하세요");
            return
        } else {
            // fetch는 요청정보는 url을 전달하므로 psot 방식으로 요청ㅇ르 진행한다면 header를 통해 data를 전달
            // header에 body 키와 대응하는 값을 전달, fetch(url, header) 함수 사용
            fetch("/product/prdNoCheck4", {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json'
                },
                body: prdNo // body에 포함시켜 전송되므로 파라미터는 아님
            })
                .then(response => response.text())
                .then(result => {
                    console.log(result);
                    if (result == "avaliable") {
                        alert("사용가능한 번호4");
                    } else {
                        alert("사용불가능한 번호4");
                    }
                })	
                .catch(err => console.log(err));



        } // else 끝




    }); // on 끝 
}); // ready 끝