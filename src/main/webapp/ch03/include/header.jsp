<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>헤더</h1>
	<%
		String title = request.getParameter("title");
		out.println(title); // 브라우저 화면에 출력
	%>
</body>
</html>