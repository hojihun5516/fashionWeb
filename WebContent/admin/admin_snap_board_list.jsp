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

<style type="text/css">
 
 .section1{
	margin: 70px auto;
	width: 1280px;
	height: 100%;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}
.header{
	margin : 30px auto;
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
		<section class="section2">
			
		 	<c:forEach var="snapList" items="${snapList }">
			<div style="width: 320px; height: 370px; float: left; text-align: center;">
				<a href="SnapServlet?command=Snap_View&num=${snapList.num }" style="text-decoration: none;">
				<img class="img" alt="사진없음" src="${snapList.image }" width="250px" height="300px"><br>
		 		${snapList.title }<br>
				<a href="AdminServlet?command=admin_member_update_form&nick=${snapList.nick}">${snapList.nick }</a>(${snapList.age })<br>
				<input type="button" value="삭제 " onclick="location.href='AdminServlet?command=admin_snap_board_delete&num=${snapList.num}'" >
				</a>
			</div>
		 	</c:forEach>
 		</section>
	</section>
	
	
	
</form>
</body>
</html>