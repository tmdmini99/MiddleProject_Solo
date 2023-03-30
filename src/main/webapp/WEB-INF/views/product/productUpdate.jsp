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
<form action="./productUpdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${member.id}">
	<input type="hidden" name="productNum" value="${dto.productNum}">
	productName : <input type="text" name="productName" value="${dto.productName}">
	<div id="catdiv">
		<c:forEach items="${dto.categorieDTOs}" var="dtos">
		<div class="row input-group mb-3">
			<label for="categoryNum" class="visually-hidden">categoryName</label>
			<select class="form-select" name="categoryNum" id="categoryName">
				<option value="2" ${dtos.categoryNum eq '2' ? 'selected':''}>컴퓨터</option>
				<option value="3" ${dtos.categoryNum eq '3' ? 'selected':''}>노트북</option>
				<option value="4" ${dtos.categoryNum eq '4' ? 'selected':''}>모니터</option>
				<option value="5" ${dtos.categoryNum eq '5' ? 'selected':''}>휴대폰</option>
				<option value="6" ${dtos.categoryNum eq '6' ? 'selected':''}>TV</option>
				<option value="7" ${dtos.categoryNum eq '7' ? 'selected':''}>냉장고</option>
				<option value="8" ${dtos.categoryNum eq '8' ? 'selected':''}>에어컨</option>
				<option value="9" ${dtos.categoryNum eq '9' ? 'selected':''}>공기청정기</option>
			</select>
			<button type="button" id="btn1" class="btn btn-outline-danger del ">카테고리 삭제</button>
	</div>
	</c:forEach>
	<button type="button" id="btn">카테고리 추가</button>
	</div>
	discount : <input type="text" name="discount" value="${dto.discount}">
	discountPercent :<input type="text" name="discountPercent" value="${dto.discountPercent}">
	ProductSales ok : <input type="radio" checked name="productSales" value="1">
	ProductSales no : <input type="radio" name="productSales" value="0">
		
	<div id="fileList">
		<!-- <div class="mb-3">
			<label for="files" class="form-label">Image</label>
			<input type="file" class="form-control" id="files" name="pic">
		</div> -->
		
		<button type="button" id="btn3">add</button>
		<c:if test="${not empty dto.productFileDTOs.size()}">
						<c:forEach items="${dto.productFileDTOs}" var="fileDTO">
							<div class="input-group mb-3">
							  <div class="input-group-text">
							    <input class="form-check-input mt-0 deleteCheck" type="checkbox" value="${fileDTO.fileNum}" aria-label="Checkbox for following text input" name="fileNum">
							  </div>
							  <input type="text" disabled  value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">
							</div>
							
							
						</c:forEach> 
					</c:if>
		
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