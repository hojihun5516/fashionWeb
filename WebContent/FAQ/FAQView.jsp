<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 48. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script/FAQ.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q & A</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script type="text/javascript" src="script/FAQ.js"></script>
<style>
	.section{
		width : 800px;
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
<section class="section w3-container">   
		<header class="header"><h1>${board.title }</h1></header>
		<div align="center">
			<table class="w3-table w3-bordered w3-border">
				<tr>
					<th class="w3-light-gray">작성자</th>
					<td>${board.nick}</td>
				</tr>
				<tr>	
					<th class="w3-light-gray">분류</th>
					<td>${board.f_category}</td>
				</tr>	
				
				<tr>
					<th class="w3-light-gray">작성일</th>
					<td><fmt:formatDate value="${board.writedate}"/></td>
				</tr>
				<tr>
					<th class="w3-light-gray">내용</th>
					<td>
						<textarea cols="70" rows="15" readonly>${board.content}</textarea>
					</td>
				</tr>	
			<c:forEach var="answer" items="${answer }">
				<tr>
					<th class="w3-light-gray"></th>
					<td>${answer.nick }&nbsp;<fmt:formatDate value="${answer.writedate }"/><br><br>
						${answer.content }
						<input type="button" value="삭제" 
						onclick="location.href='FAQservlet?command=FAQ_answer_delete&num=${answer.num}&fr_num=${answer.fr_num}'">
					</td>
					
				</tr>	
			</c:forEach>		
			</table>
			<form action="FAQservlet" method="get">
				<input type="hidden" name="command" value="FAQ_answer">
				<input type="hidden" name="fr_num" value="${board.num }">
				<input type="hidden" name="nick" value="${board.nick}">
				
				<table class="w3-table w3-bordered w3-border">
					<tr>
						<th class="w3-light-gray" style="width: 75.5px;">댓글</th>
						<td>
							<textarea rows="5" cols="70" name="content"></textarea>
							<div style="float: right;">
							<input type="submit" value="완료">
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<footer class="footer">
			<input type="button" value="삭제하기" onclick="deleteCheck('${board.num}','${board.nick}','${board.title }')"/>
			<input type="button" value="목록보기" onclick="location.href='FAQservlet?command=FAQ_list'"/>
		</footer>
	</section>			
</body>
</html>