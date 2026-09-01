<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forEach 연습문제</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="blue">
				<td width="20%">상품번호</td>
				<td width="20%">상품명</td>
				<td width="20%">상품 가격</td>
				<td width="20%">제조사</td>
			</tr>
			<c:forEach var="data" items="${prdList }">
				<tr align="center">
				<td>${data.prdNo }</td>
				<td>${data.prdName }</td>
				<td>${data.prdPrice }</td>
				<td>${data.prdCompany }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>