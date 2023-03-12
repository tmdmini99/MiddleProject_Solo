<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
	
	<a href="./member/memberLogin">로그인</a>
	<a href="./member/memberDetail">정보</a>
	
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
