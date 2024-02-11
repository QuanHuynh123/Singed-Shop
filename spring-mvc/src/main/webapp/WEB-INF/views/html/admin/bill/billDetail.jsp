<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value='/static/css/admin.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/billDetail.css'/>">
	
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
	            <div id="div-table">
	               <c:forEach var="item" items="${BillDetail }">
                   <div class="product">
                        <img src="<c:url value='/static/img/${item.image}' />" style="width: 100px; height: 100px;">
                        <div class="product-info">
                            <h3>Tên sản phẩm : ${item.nameProduct }</h3>
                            <h3>Tổng giá : ${item.totalPrice } </h3>
                            <h3>Số lượng : ${item.quanty } </h3>
                          </div>
                   </div> 
                   </c:forEach>          
                </div>
            </div>
           </div>
</body>
</html>