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
        <div class="op">
        <c:forEach items="${dto}" var="list">
        OptionName:<input type="text" name="optionName"  class="1" value="${list.optionName}">
        OptionValue :<input type="text" name="optionValue" class="idx1" data-count="1" value="${list.optionValue}">
        <!-- <button type="button" class="opv">벨류 추가</button>  -->
        <button type="button" class="opc" data-name="1" data-count="1">새로운 옵션</button>
        <button type="button" class="opdd">옵션 삭제</button>
        
        <c:forEach items="${dto2}" var="list2">
			        '<div class="op offset-md-2">'
			    OptionName:<input type="text" name="optionName" class="'+10*$(this).attr('data-name')+'">
			    OptionValue :<input type="text" name="optionValue" class="idx'+ 10*$(this).attr('data-count') +'">
			    <button type="button" class="opci" data-count="'+ 10*$(this).attr('data-count') +'" data-name="'+10*$(this).attr('data-name')+'">새로운 옵션</button>
			    <button type="button" class="opd">옵션 삭제</button>
			    <div class="op offset-md-4">
			    </div>' 
			    </div>
        	<c:forEach items="${dto3}" var="list3">
        		
        	</c:forEach>
        </c:forEach>
        
</c:forEach>
        </div>
        </div>
        
<button type="button" id="btn">옵션 수정하기</button>

</form>
<script src="/resources/js/productOption.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>