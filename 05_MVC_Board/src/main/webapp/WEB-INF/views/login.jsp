<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html data-bs-theme="dark">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
</head>

     <style>
        
        .container {
            display: flex;
            flex-direction:column;
            justify-content: space-between;
            align-items: center;
            font-size:35px;
        }
         h1 {
            font-size:35px;
            margin-top: 70px;
            margin-bottom:50px;
         }
         
         input {
             margin-top:20px;
         }
         
        
         

       
    </style>
<body>
     
   <div class="container">
        <h1>로그인</h1>   
       <form action="/login" method="post"> 
        아이디 : <input type="text" name="username"><br> <!-- name을 username로 꼭 지정해줘야 security가 인식함 -->
        비밀번호 : <input type="password" name="password" ><br>
        <input type="submit" value="로그인">
        <button><a href="/register">회원가입</a></button>
       </form>

   </div>

</body>
</html>