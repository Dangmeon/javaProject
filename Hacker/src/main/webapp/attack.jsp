<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			application.log(request.getParameter("JSESSIONID")); // 반환되는 파라미터 값을 로그에 기록하는 메소드(콘솔에 기록됨)
		%>
		<script>history.back(-1)</script>
	</body>
</html>