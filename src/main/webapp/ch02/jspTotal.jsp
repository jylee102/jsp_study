<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 종합예제</h2>
	<hr>
	
	<!-- 변수 정의, 메소드 정의... -->
	<%!
		//멤버 변수 정의
		String[] members = {"김길동", "홍길동", "김사랑", "박사랑"};
		int num1 = 10;
		
		//메소드 정의
		public int calc(int num2) {
			return num1 + num2;
		}
	%>
	
	<!-- 메소드 실행, 변수 출력 -->
	<h3>calc(10) 메소드 실행: <%=calc(10)%></h3>
	<h3>num1 변수 출력: <%=num1%></h3>
	<h3>연산: <%=num1 + 4%></h3>
	
	<!-- 배열 데이터 출력 -->
	<ul>
		<% for(String name : members) { %>
			<li><%=name%></li>
		<% } %>
	</ul>
	
	<!-- HTML주석: HTML디버깅 화면에서 보임 -->
	<%-- JSP주석: HTML디버깅 화면에서 보이지 X --%>
</body>
</html>