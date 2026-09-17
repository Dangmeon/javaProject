<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>productForm</title>
		
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		
		<script type="text/javascript" src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/bookNoCheck1.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/bookNoCheck2.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/bookNoCheck3.js'/>"></script>
	
	</head>
	<body>
		<h3>도서 정보 등록</h3>
		<form method="post" action="<c:url value='/book/insertBook'/>">
			<table>
				<tr><td>도서번호</td><td><input type="text" name="bookNo" id="bookNo">
															<button type="button" id="bookNoCheckBtn1">중복확인1</button>
															<button type="button" id="bookNoCheckBtn2">중복확인2</button>
															<button type="button" id="bookNoCheckBtn3">중복확인3</button>
															</td></tr>
				<tr><td>도서명</td><td><input type="text" name="bookName"></td></tr>
				<tr><td>저자명 </td><td> <input type="text" name="bookAuthor"></td></tr>
				<tr><td>도서가격</td><td><input type="text" name="bookPrice"></td></tr>
				<tr><td>등록일 </td> <td><input type="text" name="bookDate"></td></tr>
				<tr><td>도서재고 </td> <td><input type="text" name="bookStock"></td></tr>
				<tr><td>출판사 </td> <td><input type="text" name="pubNo"></td></tr>
				<tr><td colspan="2"><input type="submit" value="등록">
				<input type="reset" value="취소"></td></tr>
			</table>
		</form>
	</body>
</html>