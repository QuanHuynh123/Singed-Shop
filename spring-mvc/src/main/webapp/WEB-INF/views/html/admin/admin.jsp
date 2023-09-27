<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.Singedshop.security.utils.SecurityUtils" %>
<c:url var="newAPI" value="/api/new"/>
<c:url var="newURL" value="/admin"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="cache-control"	content="no-cache, no-store, must-revalidate" />
	<link rel="stylesheet" href="<c:url value='/static/css/admin.css'/>">
	
	<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<title>SINGED-SHOP</title>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value='/static/javascript/sweetalert2.min.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/static/css/sweetalert2.min.css'/>">
</head>
<body>

		<div id="content">
			<div id="header-content">
				<i class="fa-solid fa-bars"></i>
				<ul class="tab-list-product">
					<li><a>Tất cả sản phẩm</a></li>
					<li><a>Áo</a></li>
					<li><a>Quần</a></li>
					<li><a>Phụ kiện</a></li>
				</ul>
				<c:if test="${not empty message}">
					<div class="alert alert-${alert}">
			  			${message}
					</div>
				</c:if>
				<div class="container-list-product"></div>
				<i class="fa-solid fa-sort-down"></i> <i class="fa-solid fa-user"></i>
			</div>

			<div id="func">
				<c:url var="createNewProduct" value="/admin/edit"/>
				<a href='${createNewProduct}'><button id="add">Thêm</button></a>
				<button id="delete" type="button" onclick="warningBeforeDelete()">Xóa</button>
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
							<th class="style">style</th>
							<th class="type">Loại</th>
							<th class="describe">Mô tả</th>
							<th class="purchases">Lượt mua</th>
							<th class="date">Ngày tạo</th>
							<th class="edit"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${getAllProduct }">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.idProduct}" value="${item.idProduct}"><a>${item.idProduct}</a></td>
							<td><a class="input-cell" type="text" >${item.nameProduct }</a></td>
							<td><img  class="input-cell" src="product1.jpg" alt="${item.image }"></td>
							<td><a class="input-cell" type="text" >${item.quantity }</a></td>
							<td><a class="input-cell" type="text" >${item.price }</a></td>
							<td><a class="input-cell" type="text" >${item.oldPrice }</a></td>
							<td><a class="input-cell" type="text" >${item.idStyle }</a></td>
							<td><a class="input-cell" type="text" >${item.category }</a></td>
							<td><textarea class="input-cell" id="describe_edit" name="describe" rows="4" cols="50" >${item.describe }</textarea></td>
							<td><a class="input-cell" type="text" >${item.purchase }</a></td>
							<td><a class="input-cell" type="text" >${item.dateCreate }</a></td>
							<c:url var="updateProduct" value="/admin/edit">
								<c:param name="id" value="${item.idProduct}"/>
								<c:param name="category" value="${item.category}"/>
							</c:url>
							<td><a href="${updateProduct}"><button class="input-cell" type="button"><i class="fa-solid fa-pen-to-square"></i></button></a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="<c:url value='/static/javascript/admin.js'/>"></script>
	<script >
		function warningBeforeDelete() {
			swal({
				  title: "Xác nhận xóa",
				  text: "Bạn có chắc chắn muốn xóa hay không",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonClass: "btn-success",
				  cancelButtonClass: "btn-danger",
				  confirmButtonText: "Xác nhận",
				  cancelButtonText: "Hủy bỏ",
				}).then(function(isConfirm) {
				  if (isConfirm) {			// call api delete
					  	var ids = $('tbody input[type=checkbox]:checked').map(function () {
				            return $(this).val();
				        }).get();
						deleteNew(ids);
				  }
				});
		}
		
		function deleteNew(data) {
	        $.ajax({
	            url: '${newAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${newURL}?"+ "&message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${newURL}?" +"&message=error_system";
	            }
	        });
	    }
	</script>
</body>
</html>