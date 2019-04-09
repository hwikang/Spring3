<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<form action="${path }/member/insert.do">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid"/></td>
		</tr>
		<tr>
			<td>비번</td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>확인</td>
			<td><input type="submit" value="획안"/></td>
		</tr>
	</table>

</form>
</head>
<body>

</body>
</html>