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
<form action="./productOptionUpdate" method="post" id="frm">
    
    <input type="hidden" name="json1" id="json1">
    <input type="hidden" name="productNum" value="${dto[0].productNum}">
    
    
    <div class="opi">
            <button type="button" class="oi">옵션 네임</button>
        
        <c:set var="total" value="1" />
        <c:forEach items="${dto}" var="list">
        <div class="op">
        OptionName:<input type="text" name="optionName"  class="${total}" value="${list.optionName}">
        OptionValue :<input type="text" name="optionValue" class="idx${total}" data-count="1" value="${list.optionValue}">
        <!-- <button type="button" class="opv">벨류 추가</button>  -->
        <button type="button" class="opc" data-name="1" data-count="1">새로운 옵션</button>
        <button type="button" class="opdd">옵션 삭제</button>
        
        <c:forEach items="${list.options}" var="list2">
			        <div class="op offset-md-2">
			    OptionName:<input type="text" name="optionName" class="${total*10}" value="${list2.optionName}">
			    OptionValue :<input type="text" name="optionValue" class="idx${total*10}" value="${list2.optionValue}">
			    <button type="button" class="opci" >새로운 옵션</button> 
			    <button type="button" class="opd">옵션 삭제</button>
			    <div class="op offset-md-4">
			    
			    
        	<c:forEach items="${list2.options}" var="list3">
	        		<div>
							    OptionName:<input type="text" name="optionName" class="${total*100}" value="${list3.optionName}">
							    OptionValue :<input type="text" name="optionValue" class="idx${total*100}" value="${list3.optionValue}">
							    가격 :<input type="text" name="productPrice" class="proP${total*10}"  value="${list3.productPrice}">
							    재고 :<input type="text" name="productStock" class="proS${total*10}" value="${list3.productStock}">
							   <button type="button" class="opd">옵션 삭제</button>
						   </div>
        	</c:forEach>
        	</div>
        	</div>
        </c:forEach>
        <c:set var="total" value="${total+1}" />
         </div>
</c:forEach>
        </div>
       
        
<button type="button" id="btn">옵션 수정하기</button>

</form>
<script src="/resources/js/productOption.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>