<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
<style>
        h1 {
            margin-top: 70px
        }
        .form-group {
            margin: 20px 0;
           
        }
     
      
    </style>
</head>
<body>

    <div class="container">
        <h1 >게시글 정보</h1>
        <form>
       
             <div class="form-group">
                 <label for="title">Title</label>
                 <input type="text" name="title" id="title" readonly value="${board.title}"/>
             </div>
             <div class="form-group">
                <label for="content" class="btn-animation">Content</label>
                <textarea name="content" id="content" cols="30" rows="10" class="form-control" style="resize: none" readonly >${board.content}</textarea>
               <!-- <a href="/board/download?filename=${fn:replace(board.url, '/upload/', '')}"><img src="${vo.url}"/></a> -->
        	         <a href="${board.url}" download><img src="${board.url}"/></a>
             </div>
             <div class="form-group">
               <label for="writer">Writer</label>
               <input type="text" readonly id="writer" name="writer" class="form-control " value="${board.writer}"/>
             </div>
             
             
           <!--    
             <c:if test="${!empty info}">
               <sec:authentication property="principal" var="info"/> "principal" : 로그인한 정보를 가져올 수 있다. 만약에 로그인된 정보가 없으면 anonymouseUser(문자열)가 들어감
             
              작성자와 로그인 정보가 일치해야 수정, 삭제 버튼이 보일 수 있도록  
               <c:if test="${board.writer eq info.name}">
                 <a  class="btn btn-outline-warning " href="/board/update?no=${board.no}" >수정</a>
                 <a class="btn btn-outline-danger " href="/board/delete?no=${board.no}">삭제</a>
               </c:if>
             </c:if> 
             
             -->  
           
            <!-- authorize : 권한부여와 관련된 것
                 authentication : 인증과 관련된 것, 계정 정보
             -->
             <sec:authorize access="hasRole('ROLE_MEMBER')">
               <sec:authentication property="principal" var="info"/>
                <c:if test="${board.writer eq info.name}">
                 <a  class="btn btn-outline-warning " href="/board/update?no=${board.no}" >수정</a>
                 <a class="btn btn-outline-danger " href="/board/delete?no=${board.no}">삭제</a>
               </c:if>
             </sec:authorize>
             
             
              
        </form>

 

    </div>
</body>
</html>