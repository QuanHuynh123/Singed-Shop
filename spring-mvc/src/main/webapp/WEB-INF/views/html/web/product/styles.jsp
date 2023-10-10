<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/style.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>

	<h1 id="title_style">Loại sản phẩm</h1>
	<h2 id="name_style">${id}</h2>

	<div id="content_50">

		<c:if test="${ productPaginate.size() > 0 }">
			<ul class="list_product_sale">

				<c:forEach var="StyleQuanAo" items="${productPaginate }"
					varStatus="loop">

					<li class="product"><a
						href="<c:url value="/trang-chu/product/${StyleQuanAo.idProduct}/${StyleQuanAo.idStyle}"/>">
							<div class="img_product"
								style="background-image: url(<c:url value="/static/product/${StyleQuanAo.image }"/>)">
							</div>
					</a>
						<div class="infor_product">
							<a class="name_product">${StyleQuanAo.nameProduct }</a>
							<div class="div_price">
								<a class="price">${StyleQuanAo.price }</a> 
								<a class="old_price">${StyleQuanAo.oldPrice }</a>
							</div>
						</div></li>

					<c:if
						test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1) == productPaginate.size() }">
			</ul>
			<c:if test="${ (loop.index + 1) < productPaginate.size() }">
				<ul class="list_product_sale">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>


		<div class="pagination">
			<c:forEach var="item " begin="${ 1 }"
				end="${ paginateInfo.totalPage}" varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/trang-chu/styles/${id }/${loop.index }"/>"
						class="active">${loop.index}</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/trang-chu/styles/${idPhongCach }/${loop.index }"/>">${loop.index}</a>
				</c:if>
			</c:forEach>
		</div>


		<button id="btn_seeall">Xem tất cả</button>
	</div>

	<script src="<c:url value='/static/javascript/header.js'/>"></script>
	<script src="<c:url value='/static/javascript/slideProduct.js'/>"></script>
</body>
</html>