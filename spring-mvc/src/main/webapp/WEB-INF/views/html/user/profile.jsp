<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.Singedshop.security.utils.SecurityUtils" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value='/static/css/header.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/profile.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/footer.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<title>SINGED-SHOP</title>
</head>
<body>

    <div class='container'>
            <div class='avatar'>
              <img src="<c:url value='/static/img/user.jpg' />">
            </div>

            <div class='username'>
              <h3>Huỳnh Minh Quân</h3>
            </div>
			
            <div class='button' >
                <div class='button__icon'>
                  <i class='fa-solid fa-phone'></i>
                </div>
                <div class='button__text'> Số điện thoại :  </div>
                <input type="text" class="input" id="phone" value="${userProfile.phone }"/>
              </div>

            <div class='button' >
              <div class='button__icon'>
                <i class="fa-regular fa-user"></i>
              </div>
              <div class='button__text'> Tuổi : </div>
              <input type="text" class="input" id="age" value="${userProfile.age }"/>
            </div>

            <div class='button' >
              <div class='button__icon'>
                <i class="fa-solid fa-location-dot"></i>
              </div>
              <div class='button__text'> Địa chỉ :</div>
              <input type="text" class="input" id="address" value="${userProfile.address }"/>
            </div>

            <div class='button' >
              <div class='button__icon'>
                <i class="fa-solid fa-envelope"></i>
              </div>
              <div class='button__text'>Email :</div>
              <input type="text" class="input" id="email" value="${userProfile.email }"/>
            </div>

            <div class='button' >
              <div class='button__icon'>
                  <i class="fa-solid fa-venus-mars"></i>
              </div>
              <div class='button__text'>Giới tính : </div>
                  <select id="gender" name="gender">
                  <c:choose>
      				<c:when  test = "${ userProfile.gender eq 'Nam' }">
      					<option value="Nam">Nam</option>
                  		<option value="Nữ">Nữ</option>
                      	<option value="Khác">Khác</option>
      				</c:when>
      					<c:when  test = "${ userProfile.gender eq 'Nữ' }">
      					<option value="Nữ">Nữ</option>
      					<option value="Nam">Nam</option>
                      	<option value="Khác">Khác</option>
      				</c:when>
      				<c:otherwise >
                      	<option value="Khác">Khác</option>
                      	<option value="Nam">Nam</option>
                  		<option value="Nữ">Nữ</option>
      				</c:otherwise>
      			  </c:choose>
                  </select>
            </div>

            <button class="btn_save" onclick="getData()">CẬP NHẬT THÔNG TIN</button>

    </div>

    <script>
	
    // Call API bằng fetch

    function getData() {
        // Lấy giá trị từ biến input
      var email = document.getElementById('email').value;
      var phone = document.getElementById('phone').value;
      var age = document.getElementById('age').value;
      var address = document.getElementById('address').value;
      var gender = document.getElementById('gender').value;

        // Gọi hàm để thực hiện AJAX
        fetchData(email, phone, age, address, gender);
    }

    function fetchData(email, phone, age, address, gender) {
        // Sử dụng fetch để gửi yêu cầu đến API
        fetch('http://localhost:8080/spring-mvc/api/updateProfile', {
            method: 'POST', // Hoặc 'GET' tùy thuộc vào yêu cầu của bạn
            headers: {
                'Content-Type': 'application/json',
                // Các headers khác nếu cần
            },
            body: JSON.stringify({
            email: email,
            phone: phone,
            age: age,
            address: address,
            gender: gender,
            // Các trường input khác nếu cần
          }),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        });
        alert("Cập nhật thành công !")
    }
    </script>
</body>
</html>