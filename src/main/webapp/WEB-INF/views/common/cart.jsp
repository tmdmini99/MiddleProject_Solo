<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-hover">
    <thead>
        <tr>
            <th>COUNT</th>
            <th>OPTIONNUM</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${cartAdd}" var="dto" varStatus="status">
<tr><td>${dto.count}</td>
<td>${dto.optionNum}</td>
<td><button type="button" data-index="${status.index}" class="btn btn-outline-danger cartDeleteBtn">장바구니 삭제</button></td>
<td></td>
</tr>
    </c:forEach>
    </tbody>
</table>