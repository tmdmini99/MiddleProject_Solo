<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./memberJoin" method="post">
		id :<input type="text" name="id" >
		pw :<input type="text" name="pw" >
		pw 확인 :<input type="text" name="pw1">
		name :<input type="text" name="name" >
		add :<input type="text" name="address" >
		phone :<input type="text" name="phone" >
		email :<input type="text" name="email" >
		<button type="button">전송</button>
	</form>
</body>
</html>