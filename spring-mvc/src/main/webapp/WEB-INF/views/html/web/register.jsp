<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/register.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/icon/font-icon/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	
	<title>SINGED-SHOP</title>
</head>
<body> 
        <div id="content"> 
        	<form:form action="register" method="POST" modelAttribute="user">  
            <div id="background_regis">
                <div id="register">
                    	<h2 id="title_register">Đăng ký</h2>
                    	<form:input id="phone_number" type="text" path="phone" placeholder="Số điện thoại" />  
                    	<form:input id="name" type="text" path="fullName" placeholder="Tên" />  
                    	<form:input id="passwd" type="password" path="password" placeholder="Mật khẩu" />  
                    	<form:input id="passwd" type="password" path="password" placeholder="Nhập lại khẩu" />  
                    	<button type="submit" id="btn_register">Đăng ký</button>       
                </div>
            </div> 
            </form:form>
        </div>


        <script src="<c:url value='/static/javascript/test.js'/>"></script>
		<script src="<c:url value='/static/javascript/test1.js'/>"></script>

</body>
</html>