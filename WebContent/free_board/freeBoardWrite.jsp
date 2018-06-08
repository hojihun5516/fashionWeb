<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유 게시판 게시글 작성 페이지</title>
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
<form action="BoardServlet" method="post" name="frm">
	<section class="section">
		<header class="header"><h2>게시글 등록하기</h2></header>
		<input type="hidden" name="command" value="free_board_write"/>
		<div align="center">
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title">&nbsp;
						<select name="titlecolor">
								<option value="">컬러선택</option>
								<option value="red">빨강</option>
								<option value="green" >그린</option>
								<option value="blue">블루</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<footer class="footer">			
			<input type="submit" value="등록" onclick="return boardCheck()"/>
			<input type="reset" value="다시작성" />
			<input type="button" value="목록보기" onclick="location.href='BoardServlet?command=free_board_list'"/>
		</footer>
	</section>
</form>



</body>
</html>