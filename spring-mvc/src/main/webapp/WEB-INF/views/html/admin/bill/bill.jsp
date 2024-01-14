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
                            <tr>
                                <td><a class="input-cell" type="text">1</a></td>
                                <td><a class="input-cell" type="text">0703200286</a></td>
                                <td><a class="input-cell" type="text">bestleague07072002@gmail.com</a></td>
                                <td><textarea class="input-cell" id="input-address" rows="4" cols="50">83/1b Tay Lan xa Ba Diem huyen Hoc Mon</textarea></td>
                                <td><a class="input-cell" type="text">100</a></td>
                                <td><a class="input-cell" type="text">123-123-312</a></td>
                                <td><a class="input-cell" type="text">12314</a></td>
                                <td><a class="input-cell" type="text">Pending confirmation</a></td>
                                <td><button type="text" class="confirm">Xác nhận</button></td>
                            </tr>
                            <tr>
                                <td><a class="input-cell" type="text">2</a></td>
                                <td><a class="input-cell" type="text">0703200286</a></td>
                                <td><a class="input-cell" type="text">bestleague07072002@gmail.com</a></td>
                                <td><textarea class="input-cell" id="input-address" rows="4" cols="50">83/1b Tay Lan xa Ba Diem huyen Hoc Mon</textarea></td>
                                <td><a class="input-cell" type="text">100</a></td>
                                <td><a class="input-cell" type="text">123-123-312</a></td>
                                <td><a class="input-cell" type="text">12314</a></td>
                                <td><a class="input-cell" type="text">Pending confirmation</a></td>
                                <td><button  type="text" class="confirm">Xác nhận</button></td>
                            </tr>
                            <tr>
                                <td><a class="input-cell" type="text">3</a></td>
                                <td><a class="input-cell" type="text">0703200286</a></td>
                                <td><a class="input-cell" type="text">bestleague07072002@gmail.com</a></td>
                                <td><textarea class="input-cell" id="input-address" rows="4" cols="50">83/1b Tay Lan xa Ba Diem huyen Hoc Mon</textarea></td>
                                <td><a class="input-cell" type="text">100</a></td>
                                <td><a class="input-cell" type="text">123-123-312</a></td>
                                <td><a class="input-cell" type="text">12314</a></td>
                                <td><a class="input-cell" type="text">Pending confirmation</a></td>
                                <td><button type="text" class="confirm">Xác nhận</button></td>
                            </tr>
                            <!-- Thêm các dòng khác tương tự cho các sản phẩm khác -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>