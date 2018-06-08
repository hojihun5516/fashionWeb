<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   window.addEventListener("load", function(){
      var deleteCancel = document.querySelector("#deleteCancel");
      deleteCancel.addEventListener("click", function(){
         self.close();
      });
   });
      
</script>
</head>
<body>
<c:if test="${empty requestScope.num }">
   <script type="text/javascript">
      opener.location.reload();
      self.close();
      alert("삭제되었습니다.");
   </script>
</c:if>
   <form action="" method="post">
      정말 삭제하시겠습니까?<br>
      <input type="submit" value="삭제">
      <input type="button" value="취소" id="deleteCancel">
   </form> 
</body>
