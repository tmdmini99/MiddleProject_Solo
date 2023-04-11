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
cartOrder Page
주문 목록
	<div class="row cartLists">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>OPTIONNUM</th>
					<th>OPTIONNAME</th>
					<th>PRODUCTNUM</th>
					<th>PRICE</th>
					<th>COUNT</th>
            		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto" varStatus="status">
		
		<tr>
			<td><input type="hidden" class="optionNum" value="${dto.num}"></td>
		<td>${dto.optionNum}</td>
		<!-- <td>${dto.optionName}</td> -->
		<td>${dto.productNum}</td>
		<td>${dto.price*dto.count}</td>
		<td>${dto.count}</td>
		</tr>
			</c:forEach>
			
			</tbody>
		</table>
		최종 결제 금액 : ${total}
		<button type="button" data-index="${status.index}" class="btn btn-outline-danger finalPayment" data-total="${total}" data-option="${dto.optionNum}" data-product="${dto.productNum}" data-price="${dto.price}" data-count="${dto.count}">최종 결제</button>
		
	</div>




<script src="https://cdn.bootpay.co.kr/js/bootpay-3.3.1.min.js" type="application/javascript"></script>
<script src="/resources/js/finalPayment.js"></script>
<c:import url="../template/common_js.jsp"></c:import>

</body>
</html>