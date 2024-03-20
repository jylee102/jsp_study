<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 로그아웃시 세션에 저장된 정보를 지움
		session.removeAttribute("id");
		session.removeAttribute("pw");
	%>
	<script>
		// 로그아웃 후 index.jsp 페이지로 이동
		location.href = "index.jsp";
	</script>
</body>
</html>