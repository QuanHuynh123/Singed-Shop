<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/register.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	
	<title>SINGED-SHOP</title>
</head>
<body> 	
        <div id="content"> 
        	<p id="announce">${status}</p>
            <div id="background_regis">
                <form:form action="register" method="POST" modelAttribute="user">    
            		<fieldset>
                	<div id="register">
                    		<h2 id="title_register">Đăng ký</h2>
 							<form:input id="phone_number" type="text" path="phone" placeholder="Số điện thoại" />  
                    		<form:input id="name" type="text" path="fullName" placeholder="Tên" />  
                    		<form:input id="passwd" type="password" path="password" placeholder="Mật khẩu" />
                    		<input id="passwd" type="password" placeholder="Nhập lại khẩu"   />  
                 	<%--   <form:input id="passwd" type="password" path="password" placeholder="Nhập lại khẩu" />   --%>
                    		<button type="submit" id="btn_register" href="<c:url value="/login"/>">Đăng ký</button>
                	</div>
                	</fieldset>
                </form:form>
            </div>
        </div>
		
		<script src="<c:url value='/static/javascript/header.js'/>"></script>
</body>
</html>