<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${freeBoard.title }</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
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
	<header class="header"><h1>${freeBoard.title }</h1></header>
	<div align="center">
		<table class="w3-table w3-bordered w3-border">
			<tr>
				<th class="w3-light-gray">번호</th>
				<td>${freeBoard.num }</td>
			</tr>
			<tr>	
				<th class="w3-light-gray">작성자</th>
				<td>${freeBoard.nick }</td>
			</tr>
			<tr>
				<th class="w3-light-gray">작성일</th>
				<td><fmt:formatDate value="${freeBoard.writedate }"/></td>
			</tr>
			<tr>	
				<th class="w3-light-gray">조회수</th>
				<td>${freeBoard.readcount}</td>
			</tr>
			<tr>
				<th class="w3-light-gray">내용</th>
				<td>
					<textarea cols="70" rows="15" readonly>${freeBoard.content}</textarea>
				</td>
			</tr>
		</table>
	</div>
	<br>
</section>	
</body>
</html>




