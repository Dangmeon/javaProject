<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ArrayList JSTL forEach 표현</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="blue">
				<td width="20%">아이디</td>
				<td width="20%">비밀번호</td>
				<td width="20%">이름</td>
				<td width="20%">이메일</td>
			</tr>
			<c:forEach var="data" items="${memberList }">
				<tr align="center">
				<td>${data.id }</td>
				<td>${data.pwd }</td>
				<td>${data.name }</td>
				<td>${data.email }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>