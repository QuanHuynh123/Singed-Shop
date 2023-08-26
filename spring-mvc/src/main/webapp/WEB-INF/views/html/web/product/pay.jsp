<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/pay.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
<link rel="stylesheet"
	href="<c:url value='/static/icon/font-icon/themify-icons.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>

	<div id="content_pay">
		<i class="fa-solid fa-money-check-dollar"></i>
		<h1 class="title_pay">Thanh toán</h1>
		<h4 class="title_check_pay"> Vui lòng kiểm tra thông Khách hàng, thông tin Hàng trước khi đặt. </h4>
			<div id="content_infor">
				<div id="content_infor_customer">
					<h4 class="title_infor_customer">Thông tin khách hàng</h4>
					<a class="text">Họ tên</a> <input class="input"> <label
						for="gender">Giới tính:</label> 
						<select id="gender" class="select-box">
							<option value="male">Nam</option>
							<option value="female">Nữ</option>
							<option value="other">Khác</option>
						</select> 
						<a class="text">Địa chỉ</a> <input class="input"> <a class="text">Số điện thoại</a> 
						<input class="input"> <a class="text">Email</a> 
						<input class="input"> <div id="check_box_pay">
						<h4 id="title_payment">Hình thức thanh toán</h4>
						<div>
							<input type="checkbox" id="cash" name="paymentMethod" value="tienmat"> <label for="tienmat">Tiền mặt</label>
						</div>
						<div>
							<input type="checkbox" id="transfer" name="paymentMethod" value="chuyenkhoan"> <label for="chuyenkhoan">Chuyển khoản</label>
						</div>
					</div>
					<hr>
					<button id="btn_order">Đặt hàng</button>
				</div>
				<div id="content_infor_product">
					<div id="title_product">
						<h3>Sản phẩm</h3>
						<label>100</label>
					</div>
					<div id="infor_product">
						<div id="product_to_order">
							<div id="name_price">
								<h4 id="name_product"> Áo polo xấu như quỷ </h4>
	                            <h4 id="price_product"> 12000đ </h4>
							</div>
							<h4> Số lượng : x5 </h4>
						</div>
						<hr>
						<div id="product_to_order">
							<div id="name_price">
								<h4 id="name_product">Áo polo xấu như quỷ</h4>
								<h4 id="price_product"> 12000đ</h4> 
							</div>
							<h4>Số lượng : x5</h4>
						</div>
						<hr>
						<div id="product_to_order">
							<div id="name_price">
								<h4 id="name_product">Áo polo xấu như quỷ</h4>
								<h4 id="price_product">12000đ</h4>
							</div>
							<h4>Số lượng : x5</h4>
						</div>
					</div>
					<div id="total_price">Tổng thành tiền : 1231203</div>

					<div id="sale">
						<input class="code_sale" value="Mã khuyễn mãi">
						<button class="btn_code_sale">Xác nhận</button>
					</div>
				</div>
			</div>
	</div>
	<script src="<c:url value='/static/javascript/test.js'/>"></script>
	<script src="<c:url value='/static/javascript/test1.js'/>"></script>
</body>
</html>