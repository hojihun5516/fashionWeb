<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style type="text/css">
body,h1 {font-family: "Raleway", sans-serif}
  .bgimg {
    background-image: url('/BoardProject/image/29.jpg');
    min-height: 260px;
    background-position: center;
    background-size: cover;
} 
	.nav{
		margin-top: 20px;
		text-align: center;
	}
	
	a:HOVER{
		color: #636568;
		font-weight: bold;
	}
	a{
		text-decoration: none;
	}
	.menu:HOVER {
		color: #f76f4a;
		font-weight: bold;
		
	}
	.menu{
		margin-top: 10px;
	}
	.logo:HOVER {
		color: white;
		font-weight: normal;
	}
</style>
</head>
<body>
	<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
  		<div class="w3-display-middle">
    		<h1 class="w3-jumbo w3-animate-top"><a class="logo" href="MemberServlet?command=main_form&id=${member.id }&pwd=${member.pwd}">STYLE SHARE</a></h1>
    		<hr class="w3-border-grey" style="margin:auto;width:40%">
    		<p class="w3-large w3-center"></p>
  		</div>
  	</div>
	<nav class="nav w3-bar">
		<div class="w3-bar-item w3-small" style="width: 15%; margin-top: 0px;">
			<span>${member.nick }님 환영합니다.</span>
			<c:if test="${member.admin==3}">
				<a href="AdminServlet?command=admin_main_page" class="menu">
				[관리자 페이지]
				</a>
			</c:if>
			<br>
			<a href="MemberServlet?command=member_update_form&num=${member.num }" class="menu">내 정보</a>
			&nbsp;/&nbsp;
			<a href="MemberServlet?command=logout" class="menu">로그아웃</a><br>
			포인트 : ${member.points}&nbsp;LEVEL : ${member.admin}
		</div>
	    <a href="MemberServlet?command=main_form&id=${member.id }&pwd=${member.pwd}" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">HOME</a>
	    <a href="NewsServlet?command=news_board_list" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">NEWS</a>
	    <a href="UserServlet?command=user_board_list" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">회원 매거진</a>
	    <a href="BoardServlet?command=free_board_list" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">자유 게시판</a>
	    <a href="SnapServlet?command=snap_list" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">스냅 게시판</a>
	    <a href="NoticeBoardServlet?command=notice_board_list" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">공지사항</a>
	    <a href="FAQservlet?command=FAQ_list" class="menu w3-bar-item w3-medium" style="width: 12%; font-weight: bold;">Q & A</a>
	</nav>

</body>
</html>