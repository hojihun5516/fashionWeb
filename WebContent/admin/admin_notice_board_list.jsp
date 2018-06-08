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
		<header class="header"><h2>공지사항</h2></header>
		<!-- <article class="article">
			<a class="w3-button w3-light-gray w3-border-0 w3-round" href="NoticeBoardServlet?command=notice_board_write_form">글쓰기</a>
		</article> -->
		<table class="list w3-table-all w3-striped w3-centered">
				
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>수정</th>
				<th>삭제</th>

			</tr>

			<c:forEach var="noticeBoardList" items="${noticeBoardList }">
				<tr>

					<td>${noticeBoardList.num}</td>
					<td>${noticeBoardList.nick}</td>
					<td>
						<a href="AdminServlet?command=admin_notice_board_view&num=${noticeBoardList.num}">${noticeBoardList.title}</a>
					</td>
					<%-- <td><fmt:formatDate value ="${noticeBoardList.writedate}"/></td> --%>
					<td><fmt:formatDate value="${noticeBoardList.writedate }"/></td>
					<td>${noticeBoardList.readcount }</td>
					<td><input type="button" value="수정 " onclick="location.href='AdminServlet?command=admin_notice_board_update_form&num=${noticeBoardList.num}'" ></td>
					<td><input type="button" value="삭제 " onclick="location.href='AdminServlet?command=admin_notice_board_delete&num=${noticeBoardList.num}'" ></td>
				</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>