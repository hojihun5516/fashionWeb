<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!-- <link rel="stylesheet" type="text/css" href="css/board.css"> -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.section{
		width : 1280px;
		margin-left: auto;
		margin-right: auto;
		margin: 70px auto;
	}
	.header{
		text-align: center;
		margin-bottom: 40px;
		
		
	}
	.footer{
		text-align: center;
		margin-bottom: -50px;
	}
	.article{
		float: right;
		margin-bottom: 20px;
	}
</style>
</head>
<body>
	<section class="section w3-container">   
		<header class="header"><h2>모든 회원 정보</h2></header>
		<!-- <article class="article">
			<a class="w3-button w3-light-gray w3-border-0 w3-round" href="NoticeBoardServlet?command=notice_board_write_form">회원정보 추가</a>
		</article> -->
		<table class="list w3-table-all w3-striped w3-centered">
			<%-- <c:if test="${member.admin==1}"> --%>
				
			<%-- </c:if> --%>
			<tr>
				<th>회원번호</th>
				<th>회원 ID</th>
				<th>회원 PWD</th>
				<th>회원 NAME</th>
				<th>회원 NICK</th>
				<th>회원 PHONE</th>
				<th>회원 AGE</th>
				<th>회원 GENDER</th>
				<th>회원 EMAIL</th>
				<th>회원 POINTS</th>
				<th>회원 ADMIN</th>
				<th>회원 수정</th>
				<th>회원 삭제</th>
				
			</tr>

			<c:forEach var="allMember" items="${allMember}">
				<tr>

					<td>${allMember.num}</td>
					<td>${allMember.id}</td>
					<td>${allMember.pwd}</td>
					<td>${allMember.name}</td>
					<td>${allMember.nick}</td>
					<td>${allMember.phone}</td>
					<td>${allMember.age}</td>
					<td>${allMember.gender}</td>
					<td>${allMember.email}</td>
					<td>${allMember.points}</td>
					<td>${allMember.admin}</td>
					
					<td><input type="button" value="수정" onclick="location.href='AdminServlet?command=admin_member_update_form&nick=${allMember.nick}'"></td>
					<td><input type="button" value="삭제" onclick="location.href='AdminServlet?command=admin_member_delete&num=${allMember.num}'"> </td>

				</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>