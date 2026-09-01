<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c_url 사용</title>
		<link href="<c:url value='/css/index.css'/>"/>
		<script type="text/javascript" src"<c:url value = '/js/index.js'/>"></script>
	</head>
	<body>
		<img src="/img/apple.png"> <!-- 잘못된 경로 : http://ocalhost:8080/img/apple.png -->
		<img src="../img/apple.png"> <!-- 현재 위치에서 상위 폴더로 이동 후 img 폴더로 이동 http://localhost:8080/JSP01/img/apple.png -->
		<img src="<c:url value='/img/apple.png'/>">
		<!-- 현재 위치 상관없이 contextPath 찾아감 맨 앛의 /가 contextPath 다음을 의미 -->
	</body>
</html>