<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/member.css">
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<div class="joinFormOutside" align="center">	
	<div class="joinForm" style="width: 500px; margin: 3%" align="left">
		<form action="MemberServlet" method="post" class="w3-container w3-light-grey" name="frm">
			<h2>회원가입</h2>
			<label for="id">아이디</label>
			<input class="w3-input w3-border w3-round" type="text" id="id" name="id">
			<input type="hidden" name="reid" value="">
			<input type="hidden" name="command" value="member_insert">
			<input class="w3-button w3-border w3-white w3-round" type="button" value="중복확인" onclick="idCheck()"><br>
			<label for="pwd">비밀번호</label>
			<input class="w3-input w3-border w3-round" type="password" id="pwd" name="pwd"><br>
			<label for="pwdCheck">비밀번호 확인</label>
			<input class="w3-input w3-border w3-round" type="password" id="pwdCheck" name="pwdCheck"><br>
			<label for="name">이름</label>
			<input class="w3-input w3-border w3-round" type="text" id="name" name="name"><br>
			<label for="nick">닉네임</label>
			<input class="w3-input w3-border w3-round" type="text" id="nick" name="nick"><br>
			<label for="phone">전화번호</label>
			<input class="w3-input w3-border w3-round" type="text" id="phone" name="phone"><br>
			<label for="age">나이</label>
			<input class="w3-input w3-border w3-round" type="text" id="age" name="age"><br>
			<label for="gender">성별</label>&nbsp;&nbsp;
			<input class="w3-radio" type="radio" name="gender" value="남" checked="checked">남성
			<input class="w3-radio" type="radio" name="gender" value="여">여성<br><br>
			<label for="email">이메일</label>
			<input class="w3-input w3-border w3-round" type="text" id="email" name="email"><br>
			<div align="center">
				<input class="w3-button w3-border w3-white w3-round" type="submit" value="회원 가입" onclick="return joinCheck()">
				<input class="w3-button w3-border w3-white w3-round" type="button" value="취소" onclick="location.href='/BoardProject/login.jsp'">
			</div>
			<br>
		</form>
	</div>
</div>	
</body>
</html>