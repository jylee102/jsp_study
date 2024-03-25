<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생정보</h2> <a href="/jsp_study/studentControl">정보보기</a>
	<hr>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>id</th>
			<th>이름</th>
			<th>대학교</th>
			<th>생일</th>
			<th>이메일</th>
		</tr>
		
		<!-- for(Students s : students) -->
		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.username}</td>
				<td>${s.univ}</td>
				<td>${s.birth}</td>
				<td>${s.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>학생 추가</h2>
	<hr>
	<form method="post" action="/jsp_study/studentControl?action=insert">
		<label style="width: 50px; display: inline-block;">이름</label>
		<input type="text" name="username" /><br>
		<label style="width: 50px; display: inline-block;">대학교</label>
		<input type="text" name="univ" /><br>
		<label style="width: 50px; display: inline-block;">생일</label>
		<input type="text" name="birth" /><br>
		<label style="width: 50px; display: inline-block;">이메일</label>
		<input type="text" name="email" /><br>
		
		<button type="submit">등록</button>
	</form>
</body>
</html>