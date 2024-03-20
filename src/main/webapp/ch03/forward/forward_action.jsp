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
		//데이터 이동시 한글이 깨지지 않도록 인코딩 처리
		request.setCharacterEncoding("UTF-8");
	%>

	<!-- forward는 페이지 이동시 request 객체를 함께 전달(파라미터 데이터가 유지) -->
	<!-- forward_action.jsp 안에서 페이지를 이동시킴(이동시 url이 변하지 X) -->
	<jsp:forward page="page_control_end.jsp">
		<jsp:param name="tel" value="010-0000-0000"/>
	</jsp:forward>
</body>
</html>