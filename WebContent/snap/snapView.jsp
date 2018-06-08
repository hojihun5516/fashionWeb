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
	width: 90%;
	height: 100%;
	/* background: aqua; */
}

.section2 {
	width: 50%;
	height: 90%;
	float: left;
	/* background: gray; */
	text-align: center;
	margin-bottom: 120px;
	margin-left: 3%;
}

.section3 {
	width: 47%;
	height: 90%;
	float: left;
	/* background: navy; */
}

.footer {
	width: 100%;
	height: 5px;
	text-align: center;
	/* background: lime; */
}

.header {
	margin: 45px auto;
	text-align: center;
}
</style>
</head>
<body>
	<form>
		<section class="section1">
			<header class="header">
				<h1>${board.title }</h1>
			</header>
			<section class="section2">
				<article>
					<img alt="이미지 없음" src="${board.image }" width="80%" height="700px;">
				</article>
			</section>
			<section class="section3">
				닉네임 : ${board.nick }<br><br> 
				나이 : ${age }<br><br>
				등록일 :
				<fmt:formatDate value="${board.writedate }" />
				<br><br> 
				조회수 : ${board.readcount }<br><br> 
				내용<br>
				<textarea rows="12" cols="70" readonly>${board.content }</textarea><br><br>
				구입 경로 <br>
				<c:choose>
					<c:when test="${member.admin >= 2 }">
						<textarea rows="5" cols="70" readonly>${board.link }</textarea>
					</c:when>
					<c:otherwise>
						<textarea rows="5" cols="70" readonly>구입 경로는 LEVEL 2 이상 보실 수 있습니다.</textarea>
					</c:otherwise>
				</c:choose>
				<br><br>
				<a class="w3-button w3-light-gray w3-border-0 w3-round"
					href="SnapServlet?command=snap_goodCount&num=${board.num }">
					좋아요(${board.good }) </a>
			</section>
		</section>
		<footer class="footer">
			<c:if test="${board.nick == member.nick }">
				<input class="w3-button w3-light-gray w3-border-0 w3-round"
					type="button" value="삭제"
					onclick="location.href='SnapServlet?command=snap_delete&num=${board.num }'">
			</c:if>
			<input class="w3-button w3-light-gray w3-border-0 w3-round"
				type="button" value="게시글 리스트"
				onclick="location.href='SnapServlet?command=snap_list'">
		</footer>
	</form>
</body>
</html>