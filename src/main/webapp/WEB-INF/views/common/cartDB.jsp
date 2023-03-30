<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-hover">
    <thead>
        <tr>
            <th ><input type="checkbox" id="checkAll"></th>
            
            <th>OPTIONNUM</th>
            <th>PRICE</th>
            <th>COUNT</th>
            <th>PRODUCTNUM</th>

        </tr>
    </thead>
    <tbody>
        <c:forEach items="${cartAdd}" var="dto" varStatus="status">
<tr>
    <td><input type="checkbox" class="checkd" value="${dto.num}"></td>
    
<td>${dto.optionNum}</td>
<td>${dto.price*dto.count}</td>
<td>${dto.count}</td>
<td>${dto.productNum}</td>
<td><button type="button" data-num="${dto.num}" class="btn btn-outline-danger cartDeleteBtn">장바구니 삭제</button></td>
<td><button type="button" data-count="${dto.count}" data-num="${dto.num}" class="btn btn-outline-info cartUpdate">수량 변경</button></td>
<td></td>
</tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" data-index="${status.index}" class="btn btn-outline-danger cartDeleteBtns">선택항목 삭제</button>
<button type="button" data-index="${status.index}" class="btn btn-outline-danger cartBuyBtns">선택항목 구입</button>
