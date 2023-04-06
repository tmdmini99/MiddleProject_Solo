<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">
                <h2>LOUIS VUITTON</h2>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/product/productList">전자제품</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/qna/list">QNA</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/notice/list" id="navbarDropdown" role="button">
                            NOITCE
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/member/memberStatus" >Status</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#" tabindex="-1">MAGAGINE</a>
                    </li>
                </ul>
                <ul class="navbar-nav ">
					<c:choose>
						<c:when test="${empty member}">
							<li class="nav-item"><a class="nav-link" href="/member/memberLogin">LOGIN</a></li>
							<li class="nav-item"><a class="nav-link" href="/member/memberAgree">JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/member/memberLogout">LOGOUT</a></li>
							<li class="nav-item"><a class="nav-link" href="/member/memberDetail?id=${member.id}">MY PAGE</a></li>
						</c:otherwise>
					</c:choose>
					
			</ul>	
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
        
    </nav>
</body>
</html>