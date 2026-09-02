<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="ProductException.jsp"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보</title>
		
		<style>
			.cls1 {
				font-size:40px;
				text-align:center;
			}
		</style>
	</head>
	<body>
		<p class="cls1">상품 정보</p>
		<table align="center" border="1" >
     		 <tr align="center" bgcolor="lightblue">
         		<td width="7%" ><b>상품 번호</b></td>
         		<td width="7%" ><b>상품명</b></td>
         		<td width="7%" ><b>상품 가격</b></td>
         		<td width="7%" ><b>상품 재고</b></td>
         		<td width="7%"><b>등록일</b></td>      
   			</tr>
   			
   			<c:choose>
   				<c:when test="${empty prdist }">
   					<tr>
   						<td colspan=5>등록된 제품이 없습니다.</td>
   					</tr>
   				</c:when>
   				<c:when test="${not empty prdist }">
   					<c:forEach var="product" items="${prdList }">
   						<tr>
   							<td>${product.prdNo }</td>
   							<td >${product.prdName}</td>
   							<td >${product.prdPrice }</td>
   							<td >${product.prdStock }</td>
   							<td >${product.prdJoinDate }</td>
   						</tr>
   					</c:forEach>
   				</c:when>
   			</c:choose>
   		</table>
	</body>
</html>