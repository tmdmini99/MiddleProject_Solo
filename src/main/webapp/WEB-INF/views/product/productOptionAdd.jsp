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
<form action="./productOptionAdd" method="post" id="frm">
    
    <input type="hidden" name="json1" id="json1">
    <input type="hidden" name="productNum" value="${dto.productNum}">
    <div class="opi">
            <button type="button" class="oi">옵션 네임</button>
        <div class="op">
        OptionName:<input type="text" name="optionName"  class="1">
        OptionValue :<input type="text" name="optionValue" class="idx1" data-count="1">
        <!-- <button type="button" class="opv">벨류 추가</button>  -->
        <button type="button" class="opc" data-name="1" data-count="1">새로운 옵션</button>
        <button type="button" class="opdd">옵션 삭제</button>
        </div>
        </div>
<button type="button" id="btn">옵션 생성하기</button>
</form>

<script src="/resources/js/productOption.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>