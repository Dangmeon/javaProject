<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 영역이 page 이므로 변수처럼 사용 가능 value 에 el 표현 사용 가능 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍감자' }" scope="page"/>
<c:set var="age" value="${20 }" scope="page"/>
<!--<c:set var="height" value="" scope="page"/>-->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:choose 활용 예시</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="skyblue">
				<td width="20%">아이디</td>
				<td width="20%">비밀번호</td>
				<td width="20%">이름</td>
				<td width="20%">나이</td>
				<td width="20%">키</td>
			</tr>
			<!-- 여기에 html 주석 포함 -->
			<c:choose>
				<%--<!-- 여기에 html 주석 포함되면 오류 발생 이 영역은 jstl 영역이고 jsp 영역의 확장 -->--%>
				<c:when test="${id==null }"> <%-- null -> 변수가 존재하지 않는 경우 --%>
					<tr align="center"><td colspan="5">아이디가 없습니다.</td></tr>
				</c:when>
				<c:when test="${pwd==null }">
					<tr align="center"><td colspan="5">비밀번호가 없습니다.</td></tr>
				</c:when>
				<c:when test="${name==null }">
					<tr align="center"><td colspan="5">이름이 없습니다.</td></tr>
				</c:when>
				<c:when test="${empty age }"> <!-- 변수는 있지만 값이 없는 경우/변숙 아예 없는 경우 -->
					<tr align="center"><td colspan="5">나이가 없습니다.</td></tr>
				</c:when>
				<c:when test="${height==' '}"> <!-- 변수는 있지만 값이 없는 경우 -->
					<tr align="center"><td colspan="5">값이 비었습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<tr align="center">
						<td>${id }</td>
						<!-- 여기에 html 주석 포함할 수 있음 html 영역으로 전환됨 -->
						<td>${pwd }</td>
						<td>${name }</td>
						<td>${age }</td>
						<td>${height }</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>