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
			<tr>
				<td class="product-thumbnail">
					<div class="pro-thumbnail-img">
						<img src="img/cart/1.jpg" alt="">
					</div>
					<div class="pro-thumbnail-info text-start">
						<h6 class="product-title-2">
							<a href="#">dummy product name</a>
						</h6>
						<p>Brand: Brand Name</p>
						<p>Model: Grand s2</p>
						<p> Color: Black, White</p>
					</div>
				</td>
				<td class="product-price">$560.00</td>
				<td class="product-quantity">
					<div class="cart-plus-minus f-left"><div class="dec qtybutton">-</div>
						<input type="text" value="02" name="qtybutton" class="cart-plus-minus-box">
					<div class="inc qtybutton">+</div></div> 
				</td>
				<td class="product-subtotal">$1020.00</td>
				<td class="product-remove">
					<a href="#"><i class="zmdi zmdi-close"></i></a>
				</td>
			</tr>
			</tbody>
		</table>
		최종 결제 금액 : ${total}
		<button type="button" data-index="${status.index}" class="btn btn-outline-danger finalPayment" data-cart="${list}">최종 결제</button>
		
	</div>



<script src="/resources/js/finalPayment.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
script
</body>
</html>