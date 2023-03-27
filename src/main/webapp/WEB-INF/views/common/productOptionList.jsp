<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="cartss">
    <select class="form-select opt" name="categoryNum">
            <option  value="0" >${list[0].optionName} 선택</option>
            <c:forEach items="${list}" var="op">
                <option value="${op.optionNum}">${op.optionValue}</option>
            </c:forEach>
    </select>
    
    </div>

