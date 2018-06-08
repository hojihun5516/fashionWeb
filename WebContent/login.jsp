<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<div class="loginFormOutside">
	<div class="loginForm">
		<form action="MemberServlet" method="post">
			<h1 class="loginH1">로그인</h1>
			<input type="hidden" name="command" value="main_form">		
			<input class="w3-input w3-border-0 w3-round" type="text" name="id" value="${vo.id }" placeholder="아이디${message2 }"><br>
			<input class="w3-input w3-border-0 w3-round" type="password" name="pwd" placeholder="비밀번호${message1 }"><br>
			<input class="w3-button w3-white w3-border-0 w3-round" type="submit" value="로그인">
			<input class="w3-button w3-white w3-border-0 w3-round" type="button" value="회원가입" onclick="join()">
		</form>
	</div>
</div>
</body>
</html>