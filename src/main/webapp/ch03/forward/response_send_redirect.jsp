<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- sendRedirect는 단순히 지정된 페이지로 이동.
	request 객체를 함께 전달하지 X(데이터 X) -->
	<% response.sendRedirect("page_control_end.jsp"); %>
</body>
</html>