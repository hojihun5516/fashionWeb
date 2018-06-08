<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
a{
	text-decoration: none;
}
.menu:HOVER {
		color: #f76f4a;
		font-weight: bold;	
}
</style>
</head>
<body>
<div class="w3-container">
	<nav class="nav w3-bar">
		<div class="w3-bar-item w3-medium" style="width: 20%;">
			<br>
			<span>${member.nick }님 운영자 모드입니다.</span><br>
			 <a href="MemberServlet?command=logout" class="menu">로그아웃</a> / 
		  	 <a href="MemberServlet?command=main_form&id=${member.id}&pwd=${member.pwd}" class="menu">일반 메인 화면으로 가기</a>
	  	</div>
		 <a	href="AdminServlet?command=admin_member_list" class="w3-bar-item w3-button w3-hover-deep-orange w3-padding-32" style="width: 13%;">회원정보 보기</a>
		 <a	href="AdminServlet?command=admin_free_board_list" class="w3-bar-item w3-button w3-hover-deep-orange w3-padding-32" style="width: 13%;">자유게시판 보기</a>
		 <a href="AdminServlet?command=admin_notice_board_list"	class="w3-bar-item w3-button w3-hover-deep-orange w3-padding-32" style="width: 13%;">공지사항 보기</a>
		 <a href="AdminServlet?command=admin_snap_board_list" class="w3-bar-item w3-button w3-hover-deep-orange w3-padding-32" style="width: 13%;">스냅게시판 보기</a>
		 <a href="AdminServlet?command=admin_faq_board_list" class="w3-bar-item w3-button w3-hover-deep-orange w3-padding-32" style="width: 13%;">Q & A 게시판 보기</a>
		 <a href="AdminServlet?command=admin_news_board_list" class="w3-bar-item w3-button w3-hover-deep-orange w3-padding-32" style="width: 13%;">NEWS게시판 보기</a>
	</nav>
</div>
</body>
</html>