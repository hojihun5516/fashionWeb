<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
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
	<form action="NoticeBoardServlet" method="post" name="frm">
	<section class="section">
		<header class="header"><h2>게시글 등록</h2></header>
			<input type="hidden" name="command" value="notice_board_write" />
			<input type="hidden" name="category" value="notice">
			<div align="center">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value=""> *필수 항목</td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" name="nick" value="${member.nick }"
							readonly></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="15" cols="70" name="content"></textarea></td>
					</tr>
				</table>
			</div>
			<br> <br> 
			<footer class="footer">
				<input type="submit" value="등록" onclick="return boardCheck()" />
				<input type="button" value="목록보기"
					onclick="location.href='NoticeBoardServlet?command=notice_board_list'" />
			</footer>
	</section>
	</form>

</body>
</html>

