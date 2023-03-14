<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<c:import url="./template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
<h1>
	Hello world!  
</h1>
	
	
	<c:choose>
		<c:when test="${empty member}">
			<a href="./member/memberLogin">로그인</a>
			<a href="./member/memberAgree">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="./member/memberLogout">로그아웃</a>
			<a href="./member/memberDetail">정보</a>
		</c:otherwise>
	</c:choose>
	
<P>  The time on the server is ${serverTime}. </P>

<c:import url="./template/common_js.jsp"></c:import>
</body>
</html>
