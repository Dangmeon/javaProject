<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>상품 검색</h3>
		<form method="post" action="/projectData/product/prdSearch">
			<select id="type" name="type">
				<option value="">검색 조건 선택</option>
				<option value="no">제조회사</option>
			</select>
			
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
</body>
</html>