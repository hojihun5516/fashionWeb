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
<style>
.section {
	width: 1000px;
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

.section1 {
	width: 600px;
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
		<aside style="width: 97%; height: 70px;">
			<c:if test="${member.admin==3 }">
				<a class="w3-button w3-light-gray w3-border-0 w3-round"
					href="NewsServlet?command=news_insert_form" style="float: right;">글쓰기</a>
			</c:if>
		</aside>
		<section class="section1">
			<c:forEach var="newsList" items="${newsList }">
				<div class="w3-table w3-bordered">
					<h3>${newsList.title }</h3>
					<br> 등록일 :
					<fmt:formatDate value="${newsList.writedate}" />
					<br> <img class="img" alt="사진없음" src="${newsList.image }"
						width="600px" height="700px"><br>
					<pre>${newsList.content }</pre>
				</div>
				<br>
				<br>
				<hr>
				<br>
				<br>
			</c:forEach>
		</section>
	</section>
</body>
</html>