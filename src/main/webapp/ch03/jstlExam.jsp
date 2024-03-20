<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 종합 예제</h2>
	<hr>
	<h3>set, out</h3>
	<c:set var="product1" value="<h2>애플 아이폰</h2>" />
	<c:set var="product2" value="삼성 갤럭시 노트" />
	<c:set var="intArray" value="${[1, 2, 3, 4, 5]}" />
	<p>
		product1:
		<c:out value="${product1}" default="Not registered" escapeXml="true" />
	</p>
	<p>product1(el): ${product1}</p>
	<p>intArray[2]: ${intArray[2]}</p>
	
	<h3>forEach: 배열 출력</h3>
	<ul>
		<c:forEach var="num" varStatus="i" items="${intArray}">
			<li>${i.index}: ${num}</li>
		</c:forEach>
	</ul>
</body>
</html>