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
	cartList Page
	<div class="row cartLists">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>COUNT</th>
					<th>OPTIONNUM</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartAdd}" var="dto" varStatus="status">
		<tr><td>${dto.count}</td>
		<td>${dto.optionNum}</td>
		<td><button type="button" data-index="${status.index}" class="btn btn-outline-danger cartDeleteBtn">장바구니 삭제</button></td>
		<td></td>
		</tr>
			</c:forEach>
			</tbody>
		</table>
	
	</div>
<script src="/resources/js/cartList.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>