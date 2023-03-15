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
	<div class="form-floating" id="findPw">
      <input type="text" class="form-control" id="IdFind" placeholder="Id입력">
      <label for="floatingInput">Id입력</label>
      <div class="form-group">
        <label for="memberEmail" class="form-label mt-4">본인 확인 이메일</label>
     <input type="email" class="form-control" id="emailFind" aria-describedby="emailHelp" placeholder="선택입력">
         <select class="form-control" name="emaildomain" id="emaildomain" >
                     <option value="@naver.com">@naver.com</option>
                     <option value="@daum.net">@daum.net</option>
                     <option value="@gmail.com">@gmail.com</option>
                     <option value="@hanmail.com">@hanmail.com</option>
                     <option value="@yahoo.co.kr">@yahoo.co.kr</option>
                 </select>
 </div>	
      <button type="button" id="btn1">찾기</button>
    </div>
<script src="/resources/js/memberIdFind.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>