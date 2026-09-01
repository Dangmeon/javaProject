<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, exam.beans.ProductVo"
    %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	ArrayList<ProductVo> prdList = new ArrayList<>();
	prdList.add(new ProductVo("P001", "노트북", 1500000, "삼성"));
	prdList.add(new ProductVo("P002", "스마트폰", 1200000, "애플"));
		
	request.setAttribute("prdList", prdList);

%>

<jsp:forward page="c_forEach_ArrayList_result_ex.jsp"/>