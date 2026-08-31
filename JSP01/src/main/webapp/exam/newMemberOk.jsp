<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
			request.setCharacterEncoding("UTF-8");
		%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean 연습문제</title>
</head>
<body>
	<h3>Bean 속성값 출력</h3>

	<jsp:useBean id="member" class="exam.beans.MemberBean" scope="page">
		<jsp:setProperty property="*" name="member" />
	</jsp:useBean>

	아이디 :
	<%=request.getParameter("memId") %>
	<br> 비밀번호 :
	<%=request.getParameter("memPwd") %>
	<br> 성명 :
	<%=request.getParameter("memName") %>
	<br> 이메일 :
	<%=request.getParameter("memEmail") %>
	<br>
</body>
</html>