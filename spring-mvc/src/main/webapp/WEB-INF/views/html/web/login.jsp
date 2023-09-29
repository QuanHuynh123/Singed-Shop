<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/login.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<title>SINGED-SHOP</title>
</head>
<body>

        <div id="content">
            <div id="background_regis">
            	
               <c:if test="${param.incorrectAccount != null}">
                     <div class="alert alert-danger" role="alert">Tên đăng nhập hoặc mật khẩu sai!</div>
               </c:if>
               <c:if test="${param.accessDenied != null}">
                     <div class="alert alert-warning" role="alert">Bạn không có quyền truy cập!</div>
               </c:if>
               <c:if test="${param.sessionTimeout != null}">
                     <div class="alert alert-info" role="alert">Phiên làm việc hết hạn, yêu cầu đăng nhập lại!</div>
               </c:if>

            	<!-- /login-url -->
            	<security:authorize access = "isAnonymous()">
       			<form action="j_spring_security_check"  method="POST" />
       				<fieldset>
                	<div id="login">
                    	<h2 id="title_login">Đăng nhập</h2>
                    	<h3 id="name_shop">Singed/Shop</h3>
                    	<input id="phone_number" type="text" placeholder="Số điện thoại" name="j_username" required>
                    	<input id="passwd" type="password" placeholder="Mật khẩu" name="j_password"  required>
                    	<button id="btn_login" type="submit" >Đăng nhập</button>
                   		<div id="login_google">
                        	<a id="or">hoặc</a>
                        	<img id="img_google" src="<c:url value='/static/img/google.png' />">
                    	</div>
                    	<div id="reques_register"> Chưa có tài khoản? <a href="/spring-mvc/register" id="text_register">Đăng ký</a> </div>
                    	<a id="forgot_passwd" href="fogot_passwd.html">Quên mật khẩu</a>
                	</div>
                	</fieldset>
            	</form>
            	</security:authorize>
            </div>
        </div>


   		<script src="<c:url value='/static/javascript/header.js'/>"></script>
		
</body>
</html>