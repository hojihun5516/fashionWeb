<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유 게시판</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="script/board.js"></script>
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
		margin-bottom: -100px;
	}
	
</style>
</head>
<body>
	<form action="BoardServlet" name="frm">
	<section class="section w3-container">   
		<header class="header"><h2>자유게시판</h2></header>
		<table class="list w3-table-all w3-striped">			
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>추천수</th>
					<th>조회수</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="freeBoardList" items="${freeBoardList }">
				<tr>
					<td>${freeBoardList.num }</td>
					<td><a href="AdminServlet?command=admin_member_update_form&nick=${freeBoardList.nick}">${freeBoardList.nick }</a></td>
					<td>
					<a href="AdminServlet?command=admin_free_board_view&num=${freeBoardList.num }">${freeBoardList.title }</a>
					</td>
					<td><fmt:formatDate value="${freeBoardList.writedate }" /></td>
					<td>${freeBoardList.good }</td>
					<td>${freeBoardList.readcount }</td>
					<td><input type="button" value="삭제" onclick="location.href='AdminServlet?command=admin_free_board_delete&num=${freeBoardList.num}'">
 				</tr>
			</c:forEach>
			</tbody>
		</table>
		<br><br>
		
	</section>
	</form>
</body>
</html>