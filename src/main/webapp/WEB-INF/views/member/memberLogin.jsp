<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	 <form action="./memberLogin" method="post">
		<img class="mb-4" src="/resources/imgs/logo.png" alt="" width="72"
			height="57">
		<h1 class="h3 mb-3 fw-normal">로그인 화면</h1>

		<div class="form-floating">
			<input type="text" class="form-control" id="floatingInput"
				placeholder="ID입력" name="id" value="${cookie.remember.value}">
			<label for="floatingInput">ID입력</label>
		</div>
		<div class="form-floating">
			<input type="password" class="form-control" id="floatingPassword"
				placeholder="바밀번호입력" name="pw"> <label
				for="floatingPassword">비밀번호</label>
		</div>

		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember"
				name="remember"> ID 저장
			</label>
		</div>
		<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
		<a class="w-100 btn btn-lg btn-info" href="./memberIdFind">ID찾기</a> <a
			class="w-100 btn btn-lg btn-info" href="./memberPwFind">PW찾기</a>

		<p class="mt-5 mb-3 text-muted">© 2023-03-13~2023-04-14</p>
	</form> 
	<div id="page-content" class="page-wrapper section">
	<div class="login-section mb-80">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<div class="registered-customers">
						<h6 class="widget-title border-left mb-50">REGISTERED
							CUSTOMERS</h6>
						<form action="#">
							<div class="login-account p-30 box-shadow">
								<p>If you have an account with us, Please log in.</p>
								<input type="text" name="name" placeholder="Email Address">
								<input type="password" name="password" placeholder="Password">
								<p>
									<small><a href="#">Forgot our password?</a></small>
								</p>
								<button class="submit-btn-1 btn-hover-1" type="submit">login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
	
</body>
</html>