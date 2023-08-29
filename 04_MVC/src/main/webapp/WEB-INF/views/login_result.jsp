<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.kh.mvc.model.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
   <c:when test="${! empty vo }">
      <h2>로그인 정보</h2>
        <ul>
           <li>아이디 : ${vo.id} </li>
           <li>이름 : ${vo.name} </li>
           <li>주소 : ${vo.addr }</li>
        </ul>
        <a href="/index.jsp">첫 페이지로 이동</a>

   </c:when>
   
   <c:otherwise>
         <h2>로그인 실패.. 로그인을 다시 해주세요</h2>
        <a href="/login.jsp">로그인 하기</a>
         
   </c:otherwise>

</c:choose>
</body>
</html>