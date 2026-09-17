<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form param 확인</title>
</head>
<body>
	상품 번호 : ${no } <br>
	상품명 : ${name } <br>
	가격 : ${price } <br>
	제조회사 : ${mfg } <br>
	제조일 : ${mfd } <br>
	재고 : ${stock } <br>
	
	상품명 : <a href="/projectData/product/productDetail/${name}">${name}</a> <br>
	상품명 : <a href="/projectData/product/productDetail2/${name}/${stock}/${no}">${name}/${stock }/${no }</a>
	

</body>
</html>