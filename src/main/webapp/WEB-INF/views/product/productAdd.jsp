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
<form action="./productAdd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${member.id}">
	productName : <input type="text" name="productName">
	<div id="catdiv">
		<div class="row input-group mb-3">
			<label for="categoryNum" class="visually-hidden">categoryName</label>
			<select class="form-select" name="categoryNum" id="categoryName">
				<option value="2" >컴퓨터</option>
				<option value="3">노트북</option>
				<option value="4">모니터</option>
				<option value="5">휴대폰</option>
				<option value="6">TV</option>
				<option value="7">냉장고</option>
				<option value="8">에어컨</option>
				<option value="9">공기청정기</option>
			</select>
			<button type="button" id="btn1" class="btn btn-outline-danger del ">카테고리 삭제</button>
	</div>
	<button type="button" id="btn">카테고리 추가</button>
	</div>
	ProductSales ok : <input type="radio" checked name="productSales" value="1">
	ProductSales no : <input type="radio" name="productSales" value="0">
		
	<div id="fileList">
		<!-- <div class="mb-3">
			<label for="files" class="form-label">Image</label>
			<input type="file" class="form-control" id="files" name="pic">
		</div> -->
		
		<button type="button" id="btn3">add</button>
		
	</div>

	<button type="submit">상품 등록</button>
</form>
<script src="/resources/js/productCategory.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
<script>
	setMax(3);
	
	
</script>
</body>
</html>