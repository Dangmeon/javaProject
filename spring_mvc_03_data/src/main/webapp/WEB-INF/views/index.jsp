<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp 페이지 입니다 <br>
	
	<a href="/projectData/showInfo">showInfo</a> <br>
	<a href="/projectData/showInfoMV">showInfoMV</a> <br>
	<a href="/projectData/book/bookInfoView1">showInfoView1</a> <br>
	<a href="/projectData/book/bookInfoView2">showInfoView2</a> <br>
	<a href="/projectData/showInfo3">showInfo3</a> <br>
	<a href="/projectData/book/bookInfoView4">showInfoView4</a> <br>
	<a href="<c:url value='/book/bookInfoView5'/>">showInfoView5</a> <br>
	<a href="<c:url value='/student/studentForm'/>">studentForm</a> <br>
	<a href="<c:url value='/product/productForm'/>">productForm</a> <br>
	<a href="<c:url value='/student/studentForm2'/>">studentFormBirth</a> <br>
	<a href="<c:url value='/newView'/>">PathTest</a> <br>
	<a href="<c:url value='/product/productResult'/>">productPath</a> <br>
	<a href="<c:url value='/student/studentSearchForm'/>">검색</a> <br>
	<a href="<c:url value='/product/prdSearchForm'/>">상품 검색</a> <br>
	<a href="<c:url value='/redirect'/>">redirect</a> <br>
	<a href="<c:url value='/redirectParam1'/>">redirectParam1</a> <br>
	<a href="<c:url value='/redirectParam2'/>">redirectParam2</a> <br>
	<a href="<c:url value='/redirectParam3'/>">redirectParam3</a> <br>

	
	
	
</body>
</html>