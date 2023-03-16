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
<div class="container pt-5 pb-5">
        <div class="row">
            
            <c:forEach items="${dto}" var="list">
	            <div class="col-md-4 col-sm-12">
	                <div class="card" data-num=${list.productNum}>
	                    <img src="https://www.louisvuitton.com/images/louis-vuitton--U_Holidays_2020_Push5_V2_DI1.jpg?wid=656" class="card-img-top" alt="...">
	                    
	                        <h2 class="card-text card-body text-center" > ${list.productName}</h2>
	                    
	                </div>
	               
	            </div>
            </c:forEach>
        </div>
    </div>
<script src="/resources/js/productList.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>