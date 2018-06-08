<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- FAQ 게시글 리스트 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAQ</title>
<script type="text/javascript" src="script/FAQ.js"></script>
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
	<header class="header"><h2>Q & A</h2></header>
<form action="FAQservlet" method="post">
	<input type="hidden" name="command" value="FAQ_category_select">
	<article class="article">
		<a class="w3-button w3-light-gray w3-border-0 w3-round" href="FAQservlet?command=FAQ_write_form">글쓰기</a>
	</article>
	<select name="f_category" onchange="this.form.submit()">
	    <option>분류선택</option>
	    <option value="가입/탈퇴">가입/탈퇴</option>
	    <option value="게시글작성">게시글작성</option>
	    <option value="포인트">포인트</option>
	    <option value="등급/등업">등급/등업</option>
		<option value="기타">기타</option>
	</select>
	<table class="list w3-table-all w3-striped w3-centered">
		
		<tr>
			<th>번호</th>
			<th>분류</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="FAQList" items="${FAQList}">
			<tr>
				<td>${FAQList.num }</td>
				<td>${FAQList.f_category }</td>
				<td>
				<c:choose>
					<c:when test="${member.nick == FAQList.nick }">
						<a href="FAQservlet?command=FAQ_view&num=${FAQList.num}">
							${FAQList.title }
						</a>
					</c:when>
					<c:otherwise>
						비밀글입니다.
					</c:otherwise>
				</c:choose>
				</td>
				<td>${FAQList.nick }</td>
				<td><fmt:formatDate value="${FAQList.writedate}"/> </td>
			</tr>
		</c:forEach>
	</table>
</form>
</section>
</body>
</html>