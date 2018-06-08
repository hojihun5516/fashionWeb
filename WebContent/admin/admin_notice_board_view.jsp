<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div id="wraps" align="center">
		<h1>상세 글 보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${notice_board.nick }</td>
				<th>글번호</th>
				<td>${notice_board.num }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${notice_board.writedate }" /></td>
				<th>조회수</th>
				<td>${notice_board.readcount }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${notice_board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${notice_board.content}</pre></td>
			</tr>
		</table>
		<br>
		<br>

	</div>

</body>
</html>