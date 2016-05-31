<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta charset="utf-8"> -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Mini 3 - Fahshion-PRJ</title>

<!-- 부트스트랩 삽입 -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">

<!-- 적용할 CSS 삽입 -->
<link href="${pageContext.request.contextPath }/css/fashionEjo.css"
	rel="stylesheet">

<!-- 폰트 적용 -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">


<title>Mini 3 - Fahshion-PRJ</title>
<script>
if("${msg}") { 
	alert("${msg}"); 
// 	location.reload();
}	
</script>
</head>
<body>
	<div class="header">
		<%@ include file="/WEB-INF/jsp/include/topMenu.jsp"%>
	</div>
	<!-- 메인 슬라이드 부분 및 임시공간 부분 시작 -->
	<div class="container">
	<div class="content">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- 베껴온 부분이라 뭐에 쓰는지 모르겠음..하지만 놔둠 -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- 슬라이드 부분 -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath }/img/slide-1.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath }/img/slide-2.JPG"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath }/img/slide-3.JPG"
									alt="">
							</div>
						</div>

						<!-- 슬라이드 옆으로 넘기는 부분 -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span class="icon-prev"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="icon-next"></span>
						</a>
					</div>
					<h2 class="brand-before">
						<small>Welcome to</small>
					</h2>
					<h1 class="brand-name">Business Casual</h1>
					<hr class="tagline-divider">
					<h2>
						<small>By <strong>No.1 EJo</strong>
						</small>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						혹시 몰라서 놔두는 <strong>임시 공간</strong>
					</h2>
					<hr>
					<img class="img-responsive img-border img-left"
						src="${pageContext.request.contextPath }/img/intro-pic.jpg" alt="">
					<hr class="visible-xs">
					<p>The boxes used in this template are nested inbetween a
						normal Bootstrap row and the start of your column layout. The
						boxes will be full-width boxes, so if you want to make them
						smaller then you will need to customize.</p>
					<p>
						A huge thanks to <a href="http://join.deathtothestockphoto.com/"
							target="_blank">Death to the Stock Photo</a> for allowing us to
						use the beautiful photos that make this template really come to
						life. When using this template, make sure your photos are decent.
						Also make sure that the file size on your photos is kept to a
						minumum to keep load times to a minimum.
					</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Nunc placerat diam quis nisl vestibulum dignissim. In hac
						habitasse platea dictumst. Interdum et malesuada fames ac ante
						ipsum primis in faucibus. Pellentesque habitant morbi tristique
						senectus et netus et malesuada fames ac turpis egestas.</p>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="footer">
		<%@ include file="/WEB-INF/jsp/include/bottom.jsp"%>
	</div>


	<!-- 부트스트랩 및 제이쿼리 삽입 부분 -->
	<script
		src="${pageContext.request.contextPath }/js/jquery-2.2.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</body>
</html>





