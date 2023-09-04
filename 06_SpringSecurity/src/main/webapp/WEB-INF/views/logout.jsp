<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>로그아웃 페이지</h1>
    <!-- 이 코드가 있어야 jsp로 넘어온 후 로그아웃되어 다시 로그인 페이지로 넘어감 그런데, csrf 태그가 security 안에 있으면 이 창을 거치지 않고 바로 로그인 페이지로 넘어갈 수 있음 -->
   <form action="/logout" method="post">
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       <input type="submit" value="로그아웃">
   </form>
</body>
</html>