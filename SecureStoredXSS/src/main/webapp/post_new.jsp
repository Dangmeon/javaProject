<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 게시글 작성</title>

<script>
       
        function sanitize(val) {
            if (!val) return "";
            val = val.replaceAll("&", "&amp;");
            val = val.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
            val = val.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
            val = val.replaceAll("/", "&#x2F;");
            val = val.replaceAll("'", "&#x27;");
            val = val.replaceAll("\"", "&quot;");
            return val;
        }

        function submitHandler(){ 
            let title = document.querySelector("input[name='title']");
            let writer = document.querySelector("input[name='writer']");
            let content = document.querySelector("textarea[name='content']");
            
            if(title) 
            	title.value = sanitize(title.value);
            if(writer) 
            	writer.value = sanitize(writer.value);
            if(content) 
            	content.value = sanitize(content.value);
        }
    </script>
		
</head>
<body>
    <h1>신규 게시글 작성</h1>
    <form action="post_new_send.jsp" method="post" onsubmit="submitHandler()">
        <table>
            <tr>
                <td>작성자</td>
                <td><input type="text" name="writer"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea rows="10" cols="20" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">저장</button>
                    <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
                    <button type="reset">초기화</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>