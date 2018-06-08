<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/snap.css">
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
		<form action="SnapServlet" method="post" enctype="multipart/form-data">
			<input type="hidden" name="command" value="snap_insert">
			<input type="hidden" name="category" value="snap">
			<input type="hidden" name="num" value="${member.num }">
			<input type="hidden" name="age" value="${member.age }">
			<div align="center">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="nick" value="${member.nick }"></td>	
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="15" cols="70" name="content"></textarea></td>
					</tr>
					<tr>
						<th>구매 경로</th>
						<td><textarea rows="5" cols="70" name="link"></textarea></td>
					</tr>
					<tr>
						<th>사진첨부</th>
						<td><input type="file" name="image"></td>
					</tr>
				</table>
			</div>
			<br><br>
			<footer class="footer">
				<input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='SnapServlet?command=snap_list'">
			</footer>
		</form>
</section>
</body>
</html>