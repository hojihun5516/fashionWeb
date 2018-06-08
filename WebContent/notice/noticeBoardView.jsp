<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
<style>
.section {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	margin: 70px auto;
}

.header {
	text-align: center;
	margin-bottom: 40px;
}

.footer {
	text-align: center;
	margin-bottom: -100px;
}
</style>
</head>
<body>
	<section class="section w3-container">
		<header class="header">
			<h1>${notice_board.title }</h1>
		</header>
		<div align="center">
			<table class="w3-table w3-bordered w3-border">
				<tr>
					<th class="w3-light-gray">번호</th>
					<td>${notice_board.num }</td>
				</tr>
				<tr>
					<th class="w3-light-gray">작성자</th>
					<td>${notice_board.nick }</td>
				</tr>
				<tr>
					<th class="w3-light-gray">작성일</th>
					<td><fmt:formatDate value="${notice_board.writedate }" /></td>
				</tr>
				<tr>
					<th class="w3-light-gray">조회수</th>
					<td>${notice_board.readcount }</td>
				</tr>
				<tr>
					<th class="w3-light-gray">제목</th>
					<td colspan="3">${notice_board.title }</td>
				</tr>
				<tr>
					<th class="w3-light-gray">내용</th>
					<td><textarea cols="70" rows="15" readonly>${notice_board.content}</textarea>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<footer class="footer">
			<c:if test="${member.nick == notice_board.nick}">
				<input type="button" value="수정"
					onclick="location.href='NoticeBoardServlet?command=notice_board_update_form&num=${notice_board.num}'" />
				<input type="button" value="삭제"
					onclick="location.href='NoticeBoardServlet?command=notice_board_delete&num=${notice_board.num}'" />
			</c:if>
			<input type="button" value="게시글 리스트"
				onclick="location.href='NoticeBoardServlet?command=notice_board_list'" />
			<input type="button" value="글 쓰기"
				onclick="location.href='NoticeBoardServlet?command=notice_board_write_form'" />
		</footer>
	</section>
</body>
</html>