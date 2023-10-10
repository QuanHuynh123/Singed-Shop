<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/content50.css'/>">
<link rel="stylesheet"
	href="<c:url value='/static/css/content100.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>
	<div id="content_50">
		<div id="background_slider">
			<div id="slider"></div>
			<h2 id="title_shop" class="title_content">Singed - Shop</h2>
			<h3 id="slogan" class="title_content">IF YOU LIKE THAT</h3>
			<div id="div_sub_slogan"> 
               	<div class="glowing-icon"><i class="fa-sharp fa-solid fa-user-astronaut" id="icon_clothes"></i></div>
                <h4 class="title_content sub_slogan"> Đồng hành cùng phong cách của bạn</h4> 
            </div>
			<a href="#best_selling"><i
				class="fa-regular fa-circle-down icon_down"></i></a>
			<div id="list_slider">
				<div id="slider_child1"></div>
				<div id="slider_child2"></div>
				<div id="slider_child_mid"></div>
				<div id="slider_child4"></div>
				<div id="slider_child5"></div>
			</div>
		</div>

		<h1 id="best_selling">Top bán chạy</h1>
		<div id="list_product">

			<c:forEach var="item" items="${listBestSaleQuanAo}" varStatus="loop">
				<div class="product">
					<a href="<c:url value="/trang-chu/product/${item.idProduct}/${item.idStyle}"/>">
						<div class="img_product"
							style="background-image: url(<c:url value="/static/product/${item.image }"/>)"></div>
						<div class="infor_product">
							<a class="name_product">${item.nameProduct }</a>
							<div class="div_price">
								<a class="price">${item.price }</a> <a class="old_price">${item.oldPrice }</a>
							</div>
						</div>
				</div>
			</c:forEach>

		</div>

		<a href="<c:url value="/trang-chu/viewAll/1"/>"><button id="btn_seeall">Xem tất cả</button></a>
	</div>

	<div id="banner">
		<div id="banner_left">
			<div class="banner_img1 banner_img"></div>
			<div class="banner_img2 banner_img"></div>
			<div class="banner_img3 banner_img"></div>
			<div class="banner_img4 banner_img"></div>
			<div class="banner_img5 banner_img"></div>
		</div>
		<div id="banner_right">
			<div id="title_banner">
				<h2 class="title_h2 h2_1">SALE</h2>
				<h2 class="title_h2">UP TO</h2>
			</div>
			<div id="sale_imgbanner"></div>
		</div>
	</div>

	<hr id="line">

	<div id="content_100">
		<div id="div_new">
			<h1 id="title_newproduct">Sản phẩm mới</h1>
			<img id="icon_new" class="new"
				src="<c:url value='/static/img/new.png' />">
			<h2 id="sub_newproduct" class="new">New</h2>
		</div>

		<c:if test="${ listNewQuanAo.size() > 0 }">
			<ul class="list_product1">

				<c:forEach var="item" items="${listNewQuanAo }" varStatus="loop">
					<c:if test="${loop.index < 8}">
					<li class="product1">
					<a href="<c:url value="/trang-chu/product/${item.idProduct}/${item.idStyle}"/>">
							<div class="img_product1" style="background-image: url(<c:url value="/static/product/${item.image }"/>)"> </div>
					</a>
						<div class="infor_product1">
							<a class="name_product1">${item.nameProduct }</a>
							<div class="div_price">
								<a class="price1">${item.price }</a> <a class="old_price1">${item.oldPrice }</a>
							</div>
						</div></li>

					<c:if
						test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1) == listNewQuanAo.size() }">
			</ul>
						<c:if test="${ (loop.index + 1) < listNewQuanAo.size() }">
							<ul class="list_product1">
						</c:if>
					</c:if>
					</c:if>
			</c:forEach>
		</c:if>

		<a href="<c:url value="/trang-chu/viewAll/2"/>"><button id="btn_seeall1">Xem tất cả</button></a>
	</div>

	<script src="<c:url value='/static/javascript/header.js'/>"></script>

</body>
</html>