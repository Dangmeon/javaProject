<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			
			.cls2 {
				font-size:20px;
				text-align:center;
			}
		</style>
	</head>
	<body>
		<p class="cls1">상품 정보</p>
		   <table align="center" border="1" >
		      <tr align="center" bgcolor="lightgreen">
		         <td width="7%" ><b>상품 번호</b></td>
		         <td width="7%" ><b>상품명</b></td>
		         <td width="7%" ><b>가격</b></td>
		         <td width="7%"><b>재고</b></td>
		         <td width="7%" ><b>등록일</b></td>         
		   	 </tr>
		   	 <!-- 현재 페이지로 포워딩되면서 request의 attr 전달 : memList -->
		   	 <c:choose>
		   	 	<c:when test="${prdList==null}">
		   	 		<tr>
		   	 			<td colspan=5><b>등록된 상품이 없습니다</b></td>
		   	 		</tr>		   	 	
		   	 	</c:when>
		   	 	<c:when test="${prdList!=null}">
		   	 		<c:forEach var="product" items="${prdList}">
		   	 		 <tr>
		   	 			<td>${product.prdNo}</td>
		   				<td >${product.prdName}</td>
		   				<td >${product.prdPrice}</td>
		   				<td >${product.prdStock}</td>
		   				<td >${product.prdJoinDate}</td>	
		   			</tr>		   	 			
		   	 		</c:forEach>		   	 	
		   	 	</c:when>		   	 
		   	 </c:choose>
		   </table>		
		
	</body>
</html>











