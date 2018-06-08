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
<!-- <link rel="stylesheet" type="text/css" href="css/main.css"> -->
<style>
*{
 	-webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
     box-sizing: border-box;
} 
.section1{
	width: 1400px;
	/* height : 900px; */
	margin-left: auto;
	margin-right: auto;
	/* background: gray;  */
	
}
.section2{
	width: 750px;
	/* height: 800px; */
	float: left;
	margin-right: 20px;
	margin-top: 50px;
	/* background: aqua; */
}
.aside_sec2{
	width: 700px;
	height: 100px;
	/* background: blue; */
}
.article_sec2{
	width: 700px;
	height: 50px;
	/* background: fuchsia; */
}
.section_sec2{
	width: 700px;
	height: 650px;
	overflow: hidden;
	/* background: green; */	
}
.section1_sec2{
	width: 700px;
	height: 700px;
	/* background: teal; */
}
.article_forEach{
	width: 233px;
	height: 325px;
	float: left;
	text-align: center;
	/* background: maroon; */
}
.section3{
	width: 600px;
	/* height: 1000px; */
	float: left;
	margin-left: 20px;
	/* background: olive; */
	
}
.section3_3{
	margin-top: 50px;
	width:600px;
	height: 500px;
	float: left;
	text-align: center;
	/* background: navy; */ 
}

.section3_1{
	/* margin-top: 50px; */
	width:600px;
	height: 500px;
	float: left;
	text-align: center;
	/* background: orange; */ 
}
.article_forEach3_1{
	width: 600px;
	height: 450px;
	margin-left: auto;
	margin-right: auto;
	/* background: silver; */ 
}
.section3_2{
	width:600px;
	height: 500px;
	float: left;
	/* background: yellow; */ 
}	
</style>
</head>
<body>
<section class="section1">
	<section class="section2">
		<!-- <aside class="aside_sec2"></aside> -->
		<article class="article_sec2">
			<header class="header_sec2">
				<h2 style="float: left; margin-left: 20px;">베스트 스냅</h2>
				<a href="SnapServlet?command=snap_list" style="float: right; margin-top: 30px; margin-right: 20px;">전체보기</a>
			</header>
		</article>
		<section class="section_sec2">
			<c:forEach var="bestSnap" items="${bestSnap }">
				<article class="article_forEach">
					<a href="SnapServlet?command=Snap_View&num=${bestSnap.num }" style="text-decoration: none;">
						<img alt="사진없음" src="${bestSnap.image }" width="200px" height="240px"><br>
						${bestSnap.title }<br>
						<small>
							${bestSnap.nick }<br>
							조회수 : ${bestSnap.readcount }
						</small>
					</a>
				</article>
			</c:forEach>
		</section>
		<section class="section1_sec2">
			<aside class="aside_sec2"></aside>
			<article class="article_sec2">
			<header class="header_sec2">
				<h2 style="float: left; margin-left: 20px;">회원 매거진</h2>
				<a href="#" style="float: right; margin-top: 30px; margin-right: 20px;">전체보기</a>
			</header>
		</article>
		</section>
	</section>
	<section class="section3">
		<section class="section3_3">
			<article class="article_forEach3_1 w3-container">
				<header style="height: 50px;">
					<h2 style="float: left;">NEWS</h2>
					<a href="NewsServlet?command=news_board_list" style="float: right; margin-top: 30px;">전체보기</a>
				</header>
				<c:forEach var="news" items="${news }">
					<article style="height: 200px; width: 600px; float: left;">
						<a href="NewsServlet?command=news_board_list">
						<article style="height: 200px; width: 250px; float: left;">
							<img alt="사진없음" src="${news.image }" width="200px" height="180px" style="margin-left: -40px;">
						</article>
						<article style="width: 350px; height:200px; margin-left: 8px;">
							<div style=" margin-top:15px; height: 100px; width:550px;">
								<br><br>
								<b>${news.title }</b><br>
								<small>등록일 : <fmt:formatDate value="${news.writedate }"/></small><br><br><br>
							</div>
						</article>
						</a>	
					</article>
				</c:forEach>
			</article>
		</section>
		<section class="section3_1">
			<article class="article_forEach3_1 w3-container">
				<header>
					<h2 style="float: left;">공지사항</h2>
					<a href="NoticeBoardServlet?command=notice_board_list" style="float: right; margin-top: 30px;">전체보기</a>
				</header>
				<div align="center">
				<table class="list w3-table-all w3-striped">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
					<c:forEach var="newestNotice" items="${newestNotice }">
						<tr>
							<td>${newestNotice.num }</td>
							<td>
								<b><a href="NoticeBoardServlet?command=notice_board_view&num=${newestNotice.num}">${newestNotice.title }</a></b>
							</td>
							<td><fmt:formatDate value="${newestNotice.writedate }"/></td>
							<td>${newestNotice.readcount }</td>
						</tr>
					</c:forEach>
				</table>
				</div>
			</article>
		</section>
		<section class="section3_2">
			<article class="article_forEach3_1 w3-container">
				<header>
					<h2 style="float: left;">자유게시판(인기글)</h2>
					<a href="BoardServlet?command=free_board_list" style="float: right; margin-top: 30px;">전체보기</a>
				</header>
				<div align="center">
				<table class="list w3-table-all w3-striped">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				<c:forEach var="bestFreeBoard" items="${bestFreeBoard }">
					<tr>
						<td>${bestFreeBoard.num }</td>
						<td>
							<b><a href="BoardServlet?command=free_board_view&num=${bestFreeBoard.num }">${bestFreeBoard.title }</a></b>
						</td>
						<td><fmt:formatDate value="${bestFreeBoard.writedate }"/></td>
						<td>${bestFreeBoard.readcount }</td>
					</tr>
				</c:forEach>
				</table>
				</div>
			</article>
		</section>
	</section>
</section>
</body>
</html>