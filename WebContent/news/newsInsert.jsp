<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script>

</script>
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
<section class="section">
	<header class="header">
		<h2>글 쓰기</h2>
	</header>
		<form action="NewsServlet" method="post" enctype="multipart/form-data">
			<input type="hidden" name="command" value="news_insert">
			<input type="hidden" name="category" value="news">
			<div align="center">
				<table>
					<tr>
						<th>제목</th>
						<td><input id="link" type="text" name="title" size="50"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="15" cols="70" name="content"></textarea></td>
					</tr>
					<tr>
						<th>사진첨부</th>
						<td><input type="file" name="image"></td>
					</tr>
				</table>
			</div>
			<br><br>
			<footer class="footer">
				<input class="w3-button w3-light-gray w3-border-0 w3-round" type="submit" value="등록">
				<input class="w3-button w3-light-gray w3-border-0 w3-round" type="button" value="취소" onclick="">
			</footer>
		</form>
</section>

</body>
</html>