<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유 게시판</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="script/board.js"></script>
<script>
function doDisplay(num){
    var con = document.getElementById(num);
    if(con.style.display=='none'){
        con.style.display = '';
        
    }else{
        con.style.display = 'none';
    }
}

</script>
<style>
.section {
	width: 1280px;
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

.article {
	float: right;
	margin-bottom: 20px;
}
</style>
</head>
<c:choose>
	<c:when test="${ber==''}">
		<body>
	</c:when>
	<c:otherwise>
		<body onload="javascript:doDisplay(${ber})">
	</c:otherwise>
</c:choose>
<form action="BoardServlet" name="frm">
	<section class="section w3-container">
		<header class="header">
			<h2>자유게시판</h2>
		</header>
		<article class="article">
			<a class="w3-button w3-light-gray w3-border-0 w3-round"
				href="BoardServlet?command=free_board_write_form">글쓰기</a>
		</article>
		<table class="list w3-table-all w3-striped">
			<colgroup>
				<col style="width: 5%">
				<col style="width: 40%">
				<col style="width: 10%">
				<col style="width: 10%">
				<col style="width: 5%">
				<col style="width: 5%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>추천수</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="freeBoardList" items="${freeBoardList }">
					<tr>
						<td>${freeBoardList.num }</td>
						<td
							onclick="location.href='BoardServlet?command=free_board_read_count&num=${freeBoardList.num}'"
							style="color:${freeBoardList.titlecolor };cursor:pointer">
							${freeBoardList.title }</td>

						<td>${freeBoardList.nick }</td>
						<td><fmt:formatDate value="${freeBoardList.writedate }" /></td>
						<td>${freeBoardList.good }</td>
						<td>${freeBoardList.readcount }</td>
					</tr>

					<tr id="${freeBoardList.num }" style="display: none">
						<td></td>
						<td colspan="2">
							<ul style="list-style: none">
								<li style="width: 100%; height: 400px; list-style: none">${freeBoardList.content}</li>
								<li><c:if test="${member.nick == freeBoardList.nick}">
										<input type="button" value="수정"
											onclick="location.href='BoardServlet?command=free_board_update_form&num=${freeBoardList.num}'">
										<input type="button" value="삭제"
											onclick="location.href='BoardServlet?command=free_board_delete&num=${freeBoardList.num}'">
									</c:if> <input type="button" value="추천"
									onclick="location.href='BoardServlet?command=free_board_good&num=${freeBoardList.num}'">
								</li>
							</ul>
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<br> <br>
		<footer class="footer">
			<input type="hidden" name="command" value="free_board_nick_list" />
			닉네임 : <input type="text" name="nick"> <input type="hidden"
				name="category" value="freeBoard"> <input type="submit"
				value="검색" onclick="return nickCheck()">
		</footer>
	</section>
</form>
</body>
</html>