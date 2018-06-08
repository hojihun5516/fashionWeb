<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- 21. FAQ 글 작성 폼 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/FAQ.js"></script>
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
<section class="section">
<form action="FAQservlet" method="post" name="frm">
<header class="header"><h2>Q & A</h2></header>
	<input type="hidden" name="command" value="FAQ_write_action">
	<input type="hidden" name="category" value="FAQ">
	<div align="center">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title">
					<select name="f_category" >
						<option value="기타">분류를 지정해주세요.</option>
					    <option value="가입/탈퇴">가입/탈퇴</option>
					    <option value="게시글작성">게시글작성</option>
					    <option value="포인트">포인트</option>
					    <option value="등급/등업">등급/등업</option>  
					</select>
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="nick" value="${member.nick }" ></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="50" name="content"></textarea></td>
			</tr>		
		</table>
	</div>
	<br><br>
	<footer class="footer">
		<input type="submit" value="등록" onclick="return FAQCheck()">
		<input type="reset" value="취소" >
		<input type="button" value="목록보기" onclick="location.href='FAQservlet?command=FAQ_list'"/>
	</footer>
</form>
</section>
</body>
</html>