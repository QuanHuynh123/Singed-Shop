<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/csssale.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>

	<div id="content">
		<div id="div_slider_sale"></div>
		<div id="logo_slider_sale"></div>

		<hr id="line_sale">

		<div id="div_sale">
			<h1 id="title_sale">#SINGED</h1>
			<h2 id="sub_sale">Trả view tương ứng</h2>
		</div>

			<c:if test="${ viewAllProduct.size() > 0 }">
			<ul class="list_product">

			<c:forEach var="item" items="${viewAllProduct }" varStatus="loop">
					<li class="product">
					<a href="<c:url value="/trang-chu/product/${item.idProduct}/${item.idStyle}"/>">
						<div class="img_product" style="background-image: url(<c:url value="/static/product/${item.image }"/>)"> </div>
					</a>
						<div class="infor_product">
							<a class="name_product">${item.nameProduct }</a>
							<div class="div_price">
								<a class="price">${item.price }</a> 
								<a class="old_price">${item.oldPrice }</a>
							</div>
						</div>
					</li>

					<c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1) == viewAllProduct.size() }">
							</ul>
						<c:if test="${ (loop.index + 1) < viewAllProduct.size() }">
								<ul class="list_product">
						</c:if>
					</c:if>
			</c:forEach>
		</c:if>
		
		<div class="pagination">
			<c:forEach var="item " begin="${ 1 }"
				end="${ paginateInfo.totalPage}" varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/trang-chu/viewAll/${requestId }/${loop.index }"/>"
						class="active">${loop.index}</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/trang-chu/viewAll/${requestId }/${loop.index }"/>">${loop.index}</a>
				</c:if>
			</c:forEach>
		</div>
		
		<button id="btn_seeall">Xem tất cả</button>
	</div>

	<script src="<c:url value='/static/javascript/header.js'/>"></script>
</body>
</html>