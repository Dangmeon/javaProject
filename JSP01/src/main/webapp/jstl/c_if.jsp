<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 영역이 page 이므로 변수처럼 사용 가능 value 에 el 표현 사용 가능 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍감자' }" scope="page"/>
<c:set var="age" value="${20 }" scope="page"/>
<c:set var="height" value="${177 }" scope="page"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:if 활용 예시</title>
	</head>
	<body>
		<c:if test="${true }">
			<h3>이 태그는 if 블럭 안에 있습니다. 항상 참인 if 입니다.</h3>
		</c:if>
		<c:if test="${height > 160}">
			<h3>c:if 태그는 else 를 사용할 수 없습니다.</h3>
			<br>${name }의 키는 160보다 큽니다.
		</c:if>
		<c:if test="${id == 'hong'  && pwd == '1234'}">
			<h3>로그인 성공</h3>
		</c:if>
		<c:if test="${id == 'hong2'  && pwd == '1234'}">
			<h3>로그인 실패</h3>
		</c:if>
	</body>
</html>