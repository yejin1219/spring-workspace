<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<body>

  <h2>전체 회원 보기</h2>
     <table class="table">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>주소</th>
        </tr>


       
  
  
     <c:forEach items="${list}" var="member" >
    
     <tr>
       <td>${member.id}</td>
       <td>${member.name}</td>
       <td>${member.addr}</td>
     </tr>
   
  </c:forEach>


     </table>

</body>
</html>