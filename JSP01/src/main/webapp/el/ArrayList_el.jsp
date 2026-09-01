<!-- 
		isELIgnored=false EL 표현 사용 가능
		true 면 일반 text 처리됨
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, bean.MemberBean"
    pageEncoding="UTF-8"
    isELIgnored=false
    %>
    
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mB" class="bean.MemberBean"/> <%-- 사용자 정의 클래스를 beans 등록 --%>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>

<%
	MemberBean m1 = new MemberBean("son", "1234", "손감자", "son@test.com");
	MemberBean m2 = new MemberBean("park", "5678", "박감자", "park@test.com");
	memberList.add(m1);
	memberList.add(m2);
%>
<!DOCTYPE html>
<html>s
	<head>
		<meta charset="UTF-8">
		<title>ArrayList EL 표현</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="blue">
				<td width="20%">아이디</td>
				<td width="20%">비밀번호</td>
				<td width="20%">이름</td>
				<td width="20%">이메일</td>
			</tr>
			<tr align="center">
				<td>${memberList[0].id }</td>
				<td>${memberList[0].pwd }</td>
				<td>${memberList[0].name }</td>
				<td>${memberList[0].email }</td>
			</tr>
				<tr align="center">
				<td>${memberList[1].id }</td>
				<td>${memberList[1].pwd }</td>
				<td>${memberList[1].name }</td>
				<td>${memberList[1].email }</td>
			</tr>
		</table>
	</body>
</html>