<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예외 발생</title>
	</head>
	<body>
		예외 발생
		<h3><%=exception.toString() %></h3>
		
		<h3>상품 조회시 오류가 있습니다. 다시 시도해주세요.</h3>
		<a href="main.jsp">다시 조회하기</a>
	</body>
</html>