<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/cart.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet"
	href="<c:url value='/static/icon/font-icon/themify-icons.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>
	<div id="content_cart">
		<div class="column_product">
		
		<c:if test="${ CartSinged.size() > 0 }">
			<ul>

				<c:forEach var="item" items="${ CartSinged }" varStatus="loop">
					<li id="product_cart">
						<img class="img_product_cart" style="background-image: url(<c:url value="/static/product/${item.value.productDTO.image }"/>) ; width: 120px; height: 120px; background-size: cover; margin-left: 40px;">
							<div class="infor_product_cart">
								<div class="vertical_column">
									<h3 class="name_product_cart">${item.value.productDTO.nameProduct }</h3>
									<div class="parallel">
										<h4 class="color_product_cart">Mau</h4>
										<div class="display_color_cart last"></div>
									</div>
								<div class="parallel">
									<h4 class="size_product_cart">Size</h4>
									<h4 class="last">XL</h4>
								</div>
								<div class="parallel">
									<h4 class="quantity_product_cart">So luong</h4>
							    	<input class="last input_quanty" id="quantity-cart-${item.key}" type="number" min="1" max="1000" value="${item.value.quantity}">
								</div>
							</div>
							<div id="function">
                               <a href="/spring-mvc/Deletecart/${item.key}"><button class="delete_product_cart"> Xóa </button></a>
                               <button onclick="EditQuantityCart(this);" data-id="${item.key}" class="edit_product_cart"> Sửa</button>
                            </div>
							<div id="infor_price_product_cart">
                                <h3 class="price_product_cart">Đơn giá : ${item.value.productDTO.price}</h3>
                                <h3 class="total_price_product_cart">Tổng giá : ${item.value.totalPrice }</h3>
                            </div>
							</div>
					</li>
				
				</c:forEach>
			</ul>
		</c:if>
			
		</div>
		<div class="column_funtion">
			<h3 class="all_price_cart">Thành tiền :${TotalPriceCartSinged }</h3>
			<a href="/spring-mvc/trang-chu/pay"><button  class="btn_buy_cart">Mua</button></a>
			<a href="/spring-mvc/DeleteAllcart"><button class="btn_delete_cart">Xóa tất cả</button> </a>
		</div>
	</div>
	
	
	
	<script type="text/javascript">
		function EditQuantityCart(button) {
			var id = $(button).data("id");
			var quanty = $("#quantity-cart-" + id).val();
			//alert(quanty);
			window.location = "/spring-mvc/Editcart/" + id +"/"+quanty;
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value='/static/javascript/header.js'/>"></script>
</body>
</html>