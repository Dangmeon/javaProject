<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- http://localhost:8080/JSP01/exam/memForm.jsp -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>beans 연습</title>
	</head>
	<body>
		<form name="Member" method="post" action="newMemberOk.jsp">
			<h2>회원 가입창</h2>
			<hr>
			<table>
		   	<tr><td>아이디</td><td><input type="text" name="memId"></td></tr>
	     	<tr><td>비밀번호</td><td><input type="password" name="memPwd"></td></tr>
	     	<tr><td>이름</td><td><input type="text" name="memName"></td></tr>
	     	<tr><td>이메일</td><td><input type="text" name="memEmail"></td></tr>
	     	</table>
	    <input type="submit" value="가입하기">  <input type="reset" value="다시입력">
	  </form>
	</body>
</html>