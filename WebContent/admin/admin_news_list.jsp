<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	.section{
		width : 1000px;
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
	.section1{
		width:600px;
		margin-left: auto;
		margin-right: auto;
		
	}
</style>
</head>
<body>
<section class="section">
	<header class="header">
			<h2>NEWS</h2>
	</header>
	<section class="section1">
		<c:forEach var="newsList" items="${newsList }">
			<div class="w3-table w3-bordered">
			${newsList.title }<br>
			등록일 : <fmt:formatDate value="${newsList.writedate}"/> &nbsp;&nbsp; 조회수 : ${newsList.readcount }<br>
			<img class="img" alt="사진없음" src="${newsList.image }" width="600px" height="700px"><br>
			<pre>${newsList.content }</pre><br>
		<!-- 	<input type="button" value ="수정" onclick="location.href="> -->
			
			<input type="button" value ="삭제" onclick="location.href='AdminServlet?command=admin_news_delete&num=${newsList.num}'">
			</div>
			<br><br><hr><br><br>
		</c:forEach>
	</section>
</section>
</body>
</html>