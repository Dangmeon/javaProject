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

	아이디 : <jsp:getProperty property="memId" name="member"/><br>
	비밀번호 : <jsp:getProperty property="memPwd" name="member"/><br>
	성명 : <jsp:getProperty property="memName" name="member"/><br>	
	이메일 : <jsp:getProperty property="memEmail" name="member"/><br>
</body>
</html>