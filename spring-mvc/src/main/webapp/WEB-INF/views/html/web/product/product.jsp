<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/product.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>
	<div id="content_product">
		<div id="div_detail_product">


			<div id="div_detail_product_left">
				<div id="img_detail_product"
					style="background-image: url(<c:url value="/static/product/${detailQuanAo.image }"/>) "></div>
				<div id="list_img_detail_product">
					<div class="img_detail_product_child1"
						style="background-image: url(<c:url value="/static/product/${detailQuanAo.image }"/>) "></div>
					<div class="img_detail_product_child2"
						style="background-image: url(<c:url value="/static/product/${detailQuanAo.image }"/>) "></div>
				</div>
			</div>
			<div id="div_detail_product_right">
				<h1 id="name_product">${detailQuanAo.nameProduct }</h1>
				<div id="price_id">
					<h3 id="price_product">Giá : ${detailQuanAo.price }</h3>
					<hr id="line">
					<h4 id="id_product">Mã : ${detailQuanAo.idProduct }</h4>
				</div>
				<h3 id="describe">Mô tả</h3>
				<p id="describe_content">${detailQuanAo.describe }</p>
				<h3 id="title_size">Size</h3>
				<ul id="list_size">
					<li class="size active" data-size="S"><a>S</a></li>
					<li class="size" data-size="M"><a>M</a></li>
					<li class="size" data-size="L"><a>L</a></li>
					<li class="size" data-size="XL"><a>XL</a></li>
					<li class="size" data-size="XXL"><a>XXL</a></li>
				</ul>

				<div class="color-picker">
					<a id="color">Màu</a>
					<div class="color circle"></div>
					<div class="list_color">
						<div class="color1 circle"></div>
						<div class="color2 circle"></div>
						<div class="color3 circle"></div>
						<div class="color4 circle"></div>
						<div class="color5 circle"></div>
						<div class="color6 circle"></div>
						<div class="color7 circle"></div>
					</div>
				</div>
				<div id="quantity_product">
					<h3 id="quantity">Số lượng : 123</h3>
					<button class="up_quantity">
						<i class="fa-solid fa-chevron-up"></i>
					</button>
					<button class="down_quantity">
						<i class="fa-solid fa-chevron-down"></i>
					</button>
				</div>
				<div id="btn">
					<a href="<c:url value="/Addcart/${detailQuanAo.idProduct}/${detailQuanAo.idStyle}"/>">
					<button type="submit" id="btn_add_cart">Thêm vào giỏ <i class="fa-solid fa-cart-shopping"></i></button></a>
						<a href="<c:url value="/trang-chu/pay/${detailQuanAo.idProduct }"/>"><button id="btn_buy">Mua ngay</button></a>
				</div>
			</div>
		</div>

		<h1 id="related_product">Sản phẩm liên quan</h1>

		<div class="product-list-container">
			<button class="prev-button">
				<i class="fa-solid fa-angles-left"></i>
			</button>
			<ul id="list_product">
				<c:forEach var="productCategory" items="${productCategory }"
					varStatus="loop">
					<c:if test="${ (loop.index ) <= 10 }">
						<li class="product"><a
							href="<c:url value="/trang-chu/product/${productCategory.idProduct}/${productCategory.idStyle}"/>">
								<div class="img_product"
									style="background-image: url(<c:url value="/static/product/${productCategory.image }"/>)"></div>
								<div class="infor_product">
									<a class="name_product">${productCategory.nameProduct }</a>
									<div class="div_price">
										<a class="price">${productCategory.price }</a> <a
											class="old_price">${productCategory.oldPrice }</a>
									</div>
								</div></li>
					</c:if>
				</c:forEach>
			</ul>
			<button class="next-button">
				<i class="fa-solid fa-angles-right"></i>
			</button>
		</div>

	</div>

	<script src="<c:url value='/static/javascript/header.js'/>"></script>
	<script src="<c:url value='/static/javascript/slideProduct.js'/>"></script>
</body>
</html>