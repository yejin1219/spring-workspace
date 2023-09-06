<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
 <h1>휴대전화 목록</h1>
 <table border="1">
    <thead>
       <tr>
          <th>모델번호</th>
          <th>모델이름</th>
          <th>가격</th>
          <th>제조사명</th>
       </tr>
      
    </thead>
    <tbody id="list">
    
    </tbody>
  </table>  
    
    
    
    
    <h1>휴대전화 정보</h1>
    <form id="phoneFrm">
        모델번호 : <input type="text" name="num" id="num"><br>
        모델이름 : <input type="text" name="model" id="model"><br>
        가격 : <input type="text" name="price" id="price"><br>
        제조사 :
           <select id="vcode" name="vcode">
              <option value="10">삼성</option>
              <option value="20">애플</option>
           </select>
           <br>
           <input type="button" value="추가하기" id="insert">
           <input type="button" value="수정하기" id="update">
           <input type="button" value="삭제하기" id="delete"> 
    </form>
   
 
   
<script>
window.load = list();
function list (){
	$.ajax({
        type:"get",
        url:"phone",
        dataType:'json',
        success: function(data){
      	  console.log(data);
            const result = eval(data);
            let resultHtml="";
            for(let item of result){
               resultHtml += '<tr>' +
                             '<td class="num">'+item.num+'</td>' +
                             '<td>'+item.model+'</td>'+
                             '<td>'+item.price+'</td>' +
                             '<td>'+item.company.vendor+'</td>'
                             +"</tr>";
            }
            $('#list').html(resultHtml);
        },
        error: function(data){
      	  console.error();
        }
     });
}
// 상세조회
$('#list').on('click', '.num', function() {
	console.log($(this).text());
	const num =$(this).text();

	$.ajax({
		url:'http://localhost:8080/api/phone/' + num,
		type:"get",

		success:function(data){
         $('#num').val(data.num);
         $('#model').val(data.model);
         $('#price').val(data.price);
         $('#vcode').val(data.vcode);
		},
      error: function(data){
         alert('조회 실패');
      }
		
	})	
});
// 추가
$('#insert').on('click', function(){

	// JSON 방식으로 전달 
	let phone = {
			num: $('#num').val(),
			model: $('#model').val(),
			price: $('#price').val(),
			vcode: $('#vcode').val()		
	};
	
	$.ajax({
		url:'http://localhost:8080/api/phone',
		type: 'post',
		data: JSON.stringify(phone),
		contentType: 'application/json',
		success:function(){

			list();
         alert('성공적으로 추가하였습니다!');
		},
      error: function(){
         alert('추가하지 못했습니다ㅠㅠ');
      }
		
	})
	 
	  
});

// 수정
$('#update').on('click', function(){
	  
   let phone = {
			num: $('#num').val(),
			model: $('#model').val(),
			price: $('#price').val(),
			vcode: $('#vcode').val()		
	};
	
	$.ajax({
		url:'http://localhost:8080/api/phone',
		type: 'put',
		data: JSON.stringify(phone),
		contentType: 'application/json',
		success:function(data){
         alert('성공적으로 수정하였습니다!');
		},
      error: function(data){
         alert('수정하지 못했습니다ㅠㅠ');
      }
		
	})
	  
});

// 삭제
$('#delete').on('click', function(){
         const num =  $('#num').val();
   
	
	$.ajax({
		url:'http://localhost:8080/api/phone/' + num,
		type: 'delete',
		
		success:function(data){
			list();
			$('#num').val("");
			$('#model').val("");
			$('#price').val("");
			$('#vcode').val("10");
         alert('성공적으로 삭제하였습니다!');
		},
      error: function(data){
         alert('삭제하지 못했습니다ㅠㅠ');
      }
		
	})
	  
});
</script>
    
    
    
 
</body>
</html>