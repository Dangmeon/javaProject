<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student Form</title>
	</head>
	<body>
		<h3>상품 정보 등록</h3>
		
		<!--<form method="post" action="/projectData/product/newProduct2"> -->
		<form method="post" action="/projectData/product/newProduct5">
			상품 번호 <input type="text" name="no"><br>
			상품명 <input type="text" name="name"><br>
			가격 <input type="number" name="price"><br>
			제조회사 <input type="text" name="mfg"><br>
			제조일 <input type="date" name="mfd"><br>
			재고 <input type="text" name="stock"><br>
			<input type="submit" value="등록"> <input type="reset" value="취소">
		</form>

	</body>
</html>