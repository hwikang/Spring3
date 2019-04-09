<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="include/header.jsp" %>
<body>
<%@ include file="include/menu.jsp" %>


<h1>link test</h1>
<a href="${path }/test/doA">do A</a>
<a href="${path }/test/doB">do B</a>
<a href="${path }/test/doC">do C</a>
<a href="${path }/test/doD">do D</a>
<a href="javascript:doF()">do F</a>
<div id="result"></div>

</body>
<script>
	function doF(){
		$.ajax({ //비동기 , 페이지가 넘어가지아늠
			type:"post",
			url:"${path}/test/doF",  //samplerestcontroller 에 있음
			success : function(result){
				$("#result").html("상품명="+result.name+",가격="+result.price);
			}
			
		})
	}
</script>

</html>