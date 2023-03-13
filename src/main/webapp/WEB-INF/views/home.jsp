<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
	
	
	<c:choose>
		<c:when test="${empty member}">
			<a href="./member/memberLogin">로그인</a>
			<a href="./member/memberJoin">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="./member/memberLogout">로그아웃</a>
			<a href="./member/memberDetail">정보</a>
		</c:otherwise>
	</c:choose>
	
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
