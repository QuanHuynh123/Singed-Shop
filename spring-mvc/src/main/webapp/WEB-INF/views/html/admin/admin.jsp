<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.Singedshop.security.utils.SecurityUtils" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="cache-control"
	content="no-cache, no-store, must-revalidate" />
<link rel="stylesheet" href="<c:url value='/static/css/admin.css'/>">
<link rel="stylesheet"
	href="<c:url value='/static/icon/font-icon/themify-icons.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<title>SINGED-SHOP</title>
</head>
<body>
	<div id="home-admin">
		<div id="menu">
			<div id="intro-admin">
				<h1 id="title-admin">Admin</h1>
				<img id="icon" src="<c:url value='/static/img/iconsinged.webp' />">
			</div>
			<div id="search">
				<i class="fa-solid fa-magnifying-glass"></i>
			</div>
			<div id="div-list-menu">
				<ul class="menu">
					<li><i class="fa-solid fa-chart-line icon-list-menu"></i> <a
						href="#">Dashboard</a></li>
					<li><i class="fa-solid fa-file icon-list-menu"></i> <a
						href="./trang-chu">Pages</a></li>
					<li><i class="fa-solid fa-house icon-list-menu"></i> <a
						href="#">Admin</a></li>
					<li><i class="fa-solid fa-gear icon-list-menu"></i> <a
						href="#">Config</a></li>
				</ul>
			</div>
		</div>

		<div id="content">
			<div id="header-content">
				<i class="fa-solid fa-bars"></i>
				<ul class="tab-list-product">
					<li><a>Tất cả sản phẩm</a></li>
					<li><a>Áo</a></li>
					<li><a>Quần</a></li>
					<li><a>Phụ kiện</a></li>
				</ul>
				<div class="container-list-product"></div>
				<i class="fa-solid fa-sort-down"></i> <i class="fa-solid fa-user"></i>
			</div>

			<div id="func">
				<button id="add">Thêm</button>
				<button id="delete">Xóa</button>
				<button id="edit">Sửa</button>
			</div>
			<div id="div-table">
				<table class="product-table">
					<thead>
						<tr>
							<th class="id">ID</th>
							<th class="name">Tên</th>
							<th class="img">Hình ảnh</th>
							<th class="quantity">Số lượng</th>
							<th class="price">Giá</th>
							<th class="old-price">Giá cũ</th>
							<th class="style">Phong cách</th>
							<th class="type">Loại</th>
							<th class="describe">Mô tả</th>
							<th class="purchases">Lượt mua</th>
							<th class="date">Ngày tạo</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="id-product"><input class="input-cell" type="text"
								value="1"></td>
							<td><input class="input-cell" type="text" value="Product 1"></td>
							<td><img src="product1.jpg" alt="Product 1"></td>
							<td><input class="input-cell" type="text" value="100"></td>
							<td><input class="input-cell" type="text" value="$10"></td>
							<td><input class="input-cell" type="text" value="$8"></td>
							<td><input class="input-cell" type="text" value="Brand A"></td>
							<td><input class="input-cell" type="text" value="Type 1"></td>
							<td class="describe-product"><input class="input-cell"
								type="text"
								value="Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất, gà , ngu như con heo , tôi là best yasuo, fqwfqwfqwfqfqfqfqf"></td>
							<td><input class="input-cell" type="text" value="13"></td>
							<td><input class="input-cell" type="text" value="13/2/2023"></td>
						</tr>
						<tr>
							<td class="id-product"><input class="input-cell" type="text"
								value="1"></td>
							<td><input class="input-cell" type="text" value="Product 1"></td>
							<td><img src="product1.jpg" alt="Product 1"></td>
							<td><input class="input-cell" type="text" value="100"></td>
							<td><input class="input-cell" type="text" value="$10"></td>
							<td><input class="input-cell" type="text" value="$8"></td>
							<td><input class="input-cell" type="text" value="Brand A"></td>
							<td><input class="input-cell" type="text" value="Type 1"></td>
							<td class="describe-product"><input class="input-cell"
								type="text"
								value="Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất, gà , ngu như con heo , tôi là best yasuo, fqwfqwfqwfqfqfqfqf"></td>
							<td><input class="input-cell" type="text" value="13"></td>
							<td><input class="input-cell" type="text" value="13/2/2023"></td>
						</tr>
						<tr>
							<td class="id-product"><input class="input-cell" type="text"
								value="1"></td>
							<td><input class="input-cell" type="text" value="Product 1"></td>
							<td><img src="product1.jpg" alt="Product 1"></td>
							<td><input class="input-cell" type="text" value="100"></td>
							<td><input class="input-cell" type="text" value="$10"></td>
							<td><input class="input-cell" type="text" value="$8"></td>
							<td><input class="input-cell" type="text" value="Brand A"></td>
							<td><input class="input-cell" type="text" value="Type 1"></td>
							<td class="describe-product"><input class="input-cell"
								type="text"
								value="Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất, gà , ngu như con heo , tôi là best yasuo, fqwfqwfqwfqfqfqfqf"></td>
							<td><input class="input-cell" type="text" value="13"></td>
							<td><input class="input-cell" type="text" value="13/2/2023"></td>
						</tr>
						<tr>
							<td class="id-product"><input class="input-cell" type="text"
								value="1"></td>
							<td><input class="input-cell" type="text" value="Product 1"></td>
							<td><img src="product1.jpg" alt="Product 1"></td>
							<td><input class="input-cell" type="text" value="100"></td>
							<td><input class="input-cell" type="text" value="$10"></td>
							<td><input class="input-cell" type="text" value="$8"></td>
							<td><input class="input-cell" type="text" value="Brand A"></td>
							<td><input class="input-cell" type="text" value="Type 1"></td>
							<td class="describe-product"><input class="input-cell"
								type="text"
								value="Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất, gà , ngu như con heo , tôi là best yasuo, fqwfqwfqwfqfqfqfqf"></td>
							<td><input class="input-cell" type="text" value="13"></td>
							<td><input class="input-cell" type="text" value="13/2/2023"></td>
						</tr>
						<tr>
							<td class="id-product"><input class="input-cell" type="text"
								value="1"></td>
							<td><input class="input-cell" type="text" value="Product 1"></td>
							<td><img src="product1.jpg" alt="Product 1"></td>
							<td><input class="input-cell" type="text" value="100"></td>
							<td><input class="input-cell" type="text" value="$10"></td>
							<td><input class="input-cell" type="text" value="$8"></td>
							<td><input class="input-cell" type="text" value="Brand A"></td>
							<td><input class="input-cell" type="text" value="Type 1"></td>
							<td class="describe-product"><input class="input-cell"
								type="text"
								value="Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất , Chất lượng như cái cc, màu thì xuất, gà , ngu như con heo , tôi là best yasuo, fqwfqwfqwfqfqfqfqf"></td>
							<td><input class="input-cell" type="text" value="13"></td>
							<td><input class="input-cell" type="text" value="13/2/2023"></td>
						</tr>

						<!-- Thêm các dòng khác tương tự cho các sản phẩm khác -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="<c:url value='/static/javascript/admin.js'/>"></script>
</body>
</html>