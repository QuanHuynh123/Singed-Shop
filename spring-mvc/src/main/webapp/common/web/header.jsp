<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Singedshop.security.utils.SecurityUtils" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div id="main-head">
	<div id="header">
		<img id="img_web" src="<c:url value='/static/img/singed.png' />">
		<ul id="navigation">
			<li><a href="/spring-mvc/trang-chu">TRANG CHỦ</a></li>
			<li><a>PHONG CÁCH</a> <a class="ti-angle-down"
				id="css_ti_angle_down"></a>

				<ul class="style">
					<c:forEach var="ListPhongCach" items="${listPhongCach }">
						<li><a
							href="/spring-mvc/styles/${ListPhongCach.idStyle}">${ListPhongCach.nameStyle}</a></li>
					</c:forEach>
				</ul></li>
			<li><a href="/spring-mvc/sale">KHUYẾN MÃI</a></li>
			<li><a>LIÊN HỆ</a></li>
		</ul>
		<div id="div_function">
			<input id="search_box" placeholder="Tìm kiếm ..">
			<div id="div_iconfunction">
				<i class="fa-solid fa-magnifying-glass icon_funtion"></i> 
				<i class="fa-solid fa-user icon_funtion profile">
					<ul class="profile_container">
						<li><a href="/spring-mvc/login">Thông tin</a></li>
						<security:authorize access="hasRole('ADMIN')">
							<li><a href="/spring-mvc/admin">Quản lý thông tin</a></li>
						</security:authorize> 
						<li><a>Đơn hàng của tôi</a></li>
						<li><a>Giỏ hàng</a></li>
						<li><a href="/spring-mvc/logout">Đăng xuất</a></li>
					</ul>
				</i> 
				<a href="/spring-mvc/cart" ><i class="fa-solid fa-cart-shopping icon_funtion" title="Số lượng: ${CartSinged.size()}"></i></a>
			</div>
		</div>
	</div>
	<div id="div_menu">
		<img id="icon_menu" src="<c:url value='/static/img/menu.png'/>">
		<div class="tab_menu">
			<i class="fa-solid fa-circle-xmark close"></i>
			<h1 id="title_menu">Danh mục sản phẩm</h1>
			<ul id="content_menu">
				<li id="title_clothes" class="tab_list_menu"><a>Áo</a> <i
					class="ti-angle-down"></i>
					<ul class="list_clothes">
						<li><a>Áo Thun</a></li>
						<li><a>Áo Sơ mi</a></li>
						<li><a>Áo Polo</a></li>
						<li><a>Áo Khoác</a></li>
						<li><a>Áo Blazer</a></li>
						<li><a>Áo Hoodie</a></li>
					</ul></li>
				<li id="title_trousers" class="tab_list_menu"><a>Quần</a> <i
					class="ti-angle-down"></i>
					<ul class="list_clothes">
						<li><a>Quần Jean</a></li>
						<li><a>Quần Tây</a></li>
						<li><a>Quần Jogger</a></li>
						<li><a>Quần Kaki</a></li>
						<li><a>Quần Baggy</a></li>
						<li><a>Quần Thun</a></li>
						<li><a>Quần Short</a></li>
					</ul></li>
				<li id="title_accessories" class="tab_list_menu"><a>Phụ
						kiện</a> <i class="ti-angle-down"></i>
					<ul class="list_clothes">
						<li><a>Nón</a></li>
						<li><a>Kính</a></li>
						<li><a>Cà vạt</a></li>
						<li><a>Thắt lưng</a></li>
					</ul></li>
			</ul>
			<div class="range_slider_div">
				<h3 id="title_price">
					Khoảng giá: <span id="value_price"></span>
				</h3>
				<input type="range" min="0" max="1000" value="0"
					class="slider_range" id="range">
			</div>
		</div>
	</div>
</div>