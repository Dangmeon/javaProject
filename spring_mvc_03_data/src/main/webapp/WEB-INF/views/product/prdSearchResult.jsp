<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr><th>상품명</th><th>상품 가격</th><th>제조회사</th></tr>
		<c:forEach var="prd" items="${prdList}">
			<tr>
				<td>${prd.name }</td>
				<td>${prd.price }</td>
				<td>${prd.mfg }</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>