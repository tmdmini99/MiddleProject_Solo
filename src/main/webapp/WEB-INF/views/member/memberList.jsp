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
					<th>NUM</th>
					<th>TITLE</th>
					<th>ID</th>
            		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto" varStatus="status">
		
		<tr>
		<td><input type="checkbox"></td>
	
		<td><a href="#">${dto.id}</a></td>
		<td>${dto.id}</td>
		
		</tr>
			</c:forEach>
			
			</tbody>
		</table>
		<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>