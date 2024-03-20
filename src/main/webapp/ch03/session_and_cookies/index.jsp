<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body {
		height: 100%;
		margin: 0;
	}
	
	form {
		height: 100%;
		display: flex;
		align-items: center;
	}
	
	label {
		width: 70px;
		display: inline-block;
	}
	
	div {
		width: 300px;
		margin: 0 auto;
	}
	
	h1 {
		font-size: 20px;
	}
</style>

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

</head>
<body>
	<form action="login.jsp" method="post">
		<div>
			<h1>관리시스템 로그인</h1>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" />
			<br />
			<label for="pw">비밀번호</label>
			<input type="password" name="pw" id="pw" />
			<br />
			<br />
			<input type="checkbox" name="loginChk" id="loginChk" />아이디 기억
			<br />
			<input type="submit" value="로그인" />
			<input type="reset" value="취소" />						
		</div>
	</form>
	
	<%
		Cookie[] c = request.getCookies(); //사용자 pc에 저장된 쿠키를 가져온다.
					
		if (c != null) { //저장된 쿠키가 있다면
			for (Cookie cf : c) {
				System.out.println("저장된 쿠키값: " + cf.getValue());
				
				if (cf.getName().equals("id")) { //가져온 쿠키의 name이 id라면
					// 쿠키에 null값을 저장했다면 값을 가지고 올 때에는 빈 문자열을 가져온다.
					if (!cf.getValue().equals("")) { //아이디 기억을 체크했을 때
						%>
						<script>
							// user 출력
							$("#id").val("<%=cf.getValue()%>");
							// check박스 체크
							$("#loginChk").prop("checked", true);
						</script>
						<%
					} else { //아이디 기억을 체크하지 않았을 때
						%>
						<script>
							// user 출력
							$("#id").val("");
							// check박스를 체크해제 상태로 변경
							$("#loginChk").prop("checked", false);
						</script>
						<%
					}
				}
			}
		}
	%>
</body>
</html>