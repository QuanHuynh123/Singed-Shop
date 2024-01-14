<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/pay.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>

	<div id="content_pay">
	<c:if test="${not empty errorMessage}">
    	<div class="error-message">${errorMessage}</div>
	</c:if>
		<i class="fa-solid fa-money-check-dollar"></i>
		<h1 class="title_pay">Thanh toán</h1>
		<h4 class="title_check_pay"> Vui lòng kiểm tra thông Khách hàng, thông tin Hàng trước khi đặt. </h4>
			<div id="content_infor">
			<form:form action="pay" method="POST" modelAttribute="bill">   
				<div id="content_infor_customer">
					<h4 class="title_infor_customer">Thông tin khách hàng</h4>
					<a class="text">Họ tên</a> <input class="input"> <label
						for="gender">Giới tính:</label> 
						<select id="gender" class="select-box">
							<option value="male">Nam</option>
							<option value="female">Nữ</option>
							<option value="other">Khác</option>
						</select> 
						<a class="text">Địa chỉ</a> 
						<form:input class="input" path="address"/> 
						<a class="text">Số điện thoại</a> 
						<form:input class="input" path="phone"/> 
						<a class="text">Email</a> 
						<form:input class="input" path="email"/> 
						<div id="check_box_pay">
						<h4 id="title_payment">Hình thức thanh toán</h4>
						<div>
							<input type="checkbox" id="cash" name="paymentMethod" value="tienmat"> <label for="tienmat">Tiền mặt</label>
						</div>
						<div>
							<input type="checkbox" id="transfer" name="paymentMethod" value="chuyenkhoan"> <label for="chuyenkhoan">Chuyển khoản</label>
						</div>
					</div>
					<hr>
					<button type="submit" id="btn_order" >Đặt hàng</button>
				</div>
			</form:form>
				<div id="content_infor_product">
					<div id="title_product">
						<h3>Sản phẩm</h3>
						<label>${TotalQuantityCart }</label>
					</div>
					<div id="infor_product">
							<ul>
								<c:forEach var="item" items="${ Cart }" varStatus="loop">
								<div id="product_to_order">
									<div id="name_price">
										<h4 id="name_product"> ${item.value.productDTO.nameProduct } </h4>
	                            		<h4 id="price_product"> ${item.value.productDTO.price } </h4>
									</div>
									<h4> Số lượng :${item.value.quantity} </h4>
								</div>
								<hr>
								</c:forEach>
							</ul>									
						
					</div>
					<div id="total_price">Tổng thành tiền : ${item.value.totalPrice }</div>
					<div id="sale">
						<input class="code_sale" value="Mã khuyễn mãi">
						<button class="btn_code_sale">Xác nhận</button>
					</div>
				</div>
			</div>
	</div>
	<script src="<c:url value='/static/javascript/header.js'/>"></script>
</body>
</html>