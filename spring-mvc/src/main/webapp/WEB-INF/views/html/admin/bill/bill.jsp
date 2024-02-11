<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value='/static/css/admin.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/bill.css'/>">
	
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
			    <h1 id="seen-detail">Click vào id để xem chi tiết đơn hàng</h1>
                <div id="div-table">
                    <table class="product-table">
                        <thead>
                            <tr>
                                <th class="id">ID</th>
                                <th class="phone">Phone</th>
                                <th class="email">Email</th>
                                <th class="address">Địa chỉ</th>
                                <th class="TotalQuanty">Số lượng</th>
                                <th class="dateOrder">Ngày đặt</th>
                                <th class="TotalAmount">Giá</th>
                                <th class="style1">Tình trạng</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="item" items="${Bill }">
                            <tr>
                                <td><a href="<c:url value="/admin/billDetail/${item.idBill }"/>" class="input-cell click_id" type="text">${item.idBill}</a></td>
                                <td><a class="input-cell" type="text">${item.phone }</a></td>
                                <td><a class="input-cell" type="text">${item.email }</a></td>
                                <td><textarea class="input-cell" id="input-address" rows="4" cols="50">${item.address }</textarea></td>
                                <td><a class="input-cell" type="text">${item.totalQuanty }</a></td>
                                <td><a class="input-cell" type="text">${item.orderDate }</a></td>
                                <td><a class="input-cell" type="text">${item.totalPrice }</a></td>
                                <td><a class="input-cell" type="text">${item.status }</a></td>
                               	<td id="button-check">
                               		<a href="<c:url value="/admin/bill/${item.idBill}/1"/>"><button type="button" class="confirm">Xác nhận</button></a>
                                    <a href="<c:url value="/admin/bill/${item.idBill}/2"/>"><button type="button" class="cancel">Hủy</button></a>
                                </td>
                            </tr>
                            </c:forEach>
                   
                            <!-- Thêm các dòng khác tương tự cho các sản phẩm khác -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>