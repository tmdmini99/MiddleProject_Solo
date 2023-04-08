<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	페이지
	<table class="table table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkAll"></th>
					<th>NUM</th>
					<th>TITLE</th>
					<th>ID</th>
            		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto" varStatus="status">
		
		<tr>
		<td><input type="checkbox" class="checkd" value="${dto.id}"></td>
	
		<td><a href="#">${dto.id}</a></td>
		<td>${dto.autoStatus}</td>
		
		</tr>
			</c:forEach>
			
			</tbody>
		</table>
		<button type="button" id="btn">권한 부여</button>
		<script src="/resources/js/memberStatus.js"></script>
		<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>