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
					<!-- <th ><input type="checkbox" id="checkAll"></th> -->
					
					<th>OPTIONNUM</th>
					<th>OPTIONNAME</th>
					<th>PRODUCTNUM</th>
					<th>PRICE</th>
					<th>COUNT</th>
            		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartAdd}" var="dto" varStatus="status">
		
		<tr>
		<td><input type="checkbox" class="checkd"  value="${dto.num}" data-optionNum="${dto.optionNum}" data-num="${dto.num}"></td>
		
		<td>${dto.optionNum}</td>
		<td>${dto.optionName}</td>
		<td>${dto.productNum}</td>
		<td>${dto.price*dto.count}</td>
		<td>${dto.count}</td>
		
		<td><button type="button" data-num="${dto.num}" class="btn btn-outline-danger cartDeleteBtn zmdi zmdi-close">장바구니 삭제</button></td>
		<!-- update도 cartListDelete.js에 넣음 -->
		<td><button type="button" data-count="${dto.count}" data-num="${dto.num}" class="btn btn-outline-info cartUpdate">수량 변경</button></td>
		</tr>
			</c:forEach>
			</tbody>
		</table>
		<button type="button" data-index="${status.index}" class="btn btn-outline-danger cartDeleteBtns">선택항목 삭제</button>
		<!-- 구매도  cartListDelete.js에 넣음 -->
		<button type="submit" data-index="${status.index}" class="btn btn-outline-dark cartBuyBtns">선택항목 구입</button>
		
	</div>

	<div class="table-content table-responsive mb-50">
		<table class="text-center">
			<thead>
				<tr>
					<th ><input type="checkbox" id="checkAll"></th>
					<th class="product-thumbnail">product</th>
					<th class="product-price">price</th>
					<th class="product-quantity">Quantity</th>
					<th class="product-subtotal">total</th>
					<th class="product-remove">remove</th>
				</tr>
			</thead>
			<tbody>
				<!-- tr -->
				<c:forEach items="${cartAdd}" var="dto" varStatus="status">
				<tr>
				<td><input type="checkbox" class="checkd"  value="${dto.num}" data-optionNum="${dto.optionNum}" data-num="${dto.num}"></td>
					<td class="product-thumbnail">
						
						<div class="pro-thumbnail-info text-start">
							<h6 class="product-title-2">
								<a href="#">${dto.optionName}</a>
							</h6>
							<!-- <p>Brand: Brand Name</p>
							<p>Model: Grand s2</p>
							<p> Color: Black, White</p> -->
						</div>
					</td>
					<td class="product-price">${dto.price}</td>
					<td class="product-quantity ">
						<div class="cart-plus-minus mx-auto"><div class="dec qtybutton" data-num="${dto.num}" data-price="${dto.price}">-</div>
							<input type="text" value="${dto.count}" name="qtybutton" class="cart-plus-minus-box" readonly>
						<div class="inc qtybutton" data-num="${dto.num}" data-price="${dto.price}">+</div></div> 
					</td>
					<td class="product-subtotal">${dto.price*dto.count}</td>
					<td class="product-remove">
						<button type="button" data-num="${dto.num}" class="btn btn-outline-danger cartDeleteBtn">장바구니 삭제</button>
					</td>
				</tr>
			</c:forEach>
			
			</tbody>
		</table>
	</div>
	

<script src="/resources/js/cartListDelete.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>