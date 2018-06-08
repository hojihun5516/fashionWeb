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

<style type="text/css">
.section1 {
	margin: 70px auto;
	width: 1280px;
	height: 100%;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.header {
	margin: 30px auto;
	/* background: gray; */
}
</style>
</head>
<body>
	<form>
		<section class="section1">
			<header class="header">
				<h2>스냅 게시판</h2>
			</header>
			<aside style="width: 97%; height: 70px;">
				<c:choose>
					<c:when test="${member.admin >=1 }">
						<a class="w3-button w3-light-gray w3-border-0 w3-round"
							href="SnapServlet?command=snap_insert_form" style="float: right;">글쓰기</a>
					</c:when>
					<c:otherwise>
						<p style="float: right;">글쓰기는 LEVEL 1 이상부터 가능합니다.</p>
					</c:otherwise>
				</c:choose>
			</aside>
			<section class="section2">

				<c:forEach var="snapList" items="${snapList }">
					<div
						style="width: 320px; height: 370px; float: left; text-align: center;">
						<a href="SnapServlet?command=Snap_View&num=${snapList.num }"
							style="text-decoration: none;"> <img class="img" alt="사진없음"
							src="${snapList.image }" width="250px" height="300px"><br>
							${snapList.title }<br> <small>${snapList.nick }</small>
						</a>
					</div>
				</c:forEach>

			</section>
		</section>



	</form>
</body>
</html>