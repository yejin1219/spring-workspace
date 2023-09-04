<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>로그인</h1>
   
   <!-- 
       CSRF(Cross-site request forgery, 사이트간 요청 위조 )
       - 스프링 시큐리티에서 CSRF 토큰을 이용하게 되면 '사이트간 위조 방지' 목적으로 사용하는 방식
       - CSRF 토큰 : 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식
       
    -->
   
   <form action="login" method="post"> 
      아이디 : <input type="text" name="username"><br> <!-- name을 username로 꼭 지정해줘야 security가 인식함 -->
      비밀번호 : <input type="password" name="password" ><br>
      <input type="submit" value="로그인">
   </form>
</body>
</html>