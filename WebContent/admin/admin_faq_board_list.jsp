<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- FAQ 게시글 리스트 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
   <header class="header"><h2>FAQ</h2></header>
<form>
<!-- 13. FAQList 들고온 상태, EL 문 사용하기 -->
   <table class="list w3-table-all w3-striped w3-centered">
      
      <tr>
         <th>글번호</th>
         <th>분류</th>
         <th>제목</th>
         <th>작성자</th>
         <th>작성일</th>
         <th>삭제</th>
      </tr>
      <c:forEach var="FAQList" items="${FAQList}">
         <tr>
            <td>${FAQList.num }</td>
            <td>${FAQList.f_category }</td>
            <td>
                  <a href="AdminServlet?command=admin_faq_view&num=${FAQList.num}">
                     ${FAQList.title }
                  </a>
            </td>
            <td>${FAQList.nick }</td>
            <td><fmt:formatDate value="${FAQList.writedate}"/> </td>
            <td><input type="button" value="삭제" onclick="location.href='AdminServlet?command=admin_faq_board_delete&num=${FAQList.num}'"></td>
          </tr>
      </c:forEach>
   </table>
</form>
</section>
</body>
</html>