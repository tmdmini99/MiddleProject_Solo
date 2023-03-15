<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>LOUIS VUITTON</title>

    <link rel="icon" href="https://www.lge.co.kr/tvs">
    <link href="style.css" rel="stylesheet" type="text/css">
    <c:import url="./template/common_css.jsp"></c:import>
</head>
<body>
   <c:import url="./template/header.jsp"></c:import>
 
    
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/resources/imgs/HERO-Banner_PC_promotion_1226_02.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/imgs/main_bn_pc_moodup_1019.gif" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
    <div class="campagine-section text-center mt-5 mb-5">
        <h2>
            JOURNEY HOME FOR THE HOLIDAYS
        </h2>
        <p>
            Starring Alicia Vikander
        </p>
        <button type="button" class="btn btn-dark">Discover the Campagine</button>
    </div>
    <div class="container pt-5 pb-5">
        <div class="row">
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <img src="https://www.louisvuitton.com/images/louis-vuitton--U_Holidays_2020_Push5_V2_DI1.jpg?wid=656" class="card-img-top" alt="...">
                    <div class="card-body text-center">
                        <h2 class="card-text">LATEST SELECTION</h2>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <img src="https://www.louisvuitton.com/images/louis-vuitton--U_Holidays_2020_Push6_V2_DI1.jpg?wid=656" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h2 class="card-text text-center">GIFTS FOR HIM</h2>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <img src="https://www.louisvuitton.com/images/louis-vuitton--U_Holidays_2020_Push7_V2_DI1.jpg?wid=656" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h2 class="card-text text-center">GIFTS FOR HER</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<c:choose>
		<c:when test="${empty member}">
			<a href="./member/memberLogin">로그인</a>
			<a href="./member/memberAgree">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="./member/memberLogout">로그아웃</a>
			<a href="./member/memberDetail">정보</a>
		</c:otherwise>
	</c:choose>
	
<P>  The time on the server is ${serverTime}. </P>
    

    <footer>
        <div class="container">
            <div class="first-line pb-5 pt-5">
                LOUIS VUITTON
            </div>
            <div class="row pb-5 pt-5 second-line ">
                <div class="flag col">
                    <img src="https://us.louisvuitton.com/flags/us.svg" width="16" height="12">
                    Unitied States
                </div>
                <div class="col"><a href="#" "="">
                    Email Sign-Up</a></div>
                <div class="col"> <a href="#">Contact Us</a></div>
                <div class="col"> <a href="#">Apps</a></div>
                <div class="col"> <a href="#">Follow Us</a></div>
                <div class="col"> <a href="#">California Transparency</a></div>
                <div class="col"><a href="#"> Legal Notice</a></div>
                <div class="col"> <a href="#">Careers</a></div>
                <div class="col"> <a href="#">Sitemap</a></div>     
            </div>         
            <div class=" mobile-footer">
                Shipt to : <img src="https://us.louisvuitton.com/flags/us.svg" width="16" height="12" class="flag-img"> Unitied States
            </div>
        </div>
    </footer>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>



<c:import url="./template/common_js.jsp"></c:import>
</body>
</html>



	
	


