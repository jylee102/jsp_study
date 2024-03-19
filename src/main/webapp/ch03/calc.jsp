<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Calculator calc = new Calculator()와 같다. -->
<jsp:useBean id="calc" class="ch03.Calculator" />

<!-- calcForm.jsp에서 입력받은 값들을 calc객체의 필드에 넣어준다.(태그의 name과 같은 필드에 넣어줌) -->
<jsp:setProperty name="calc" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	계산 결과: ${calc.calc()}
</body>
</html>