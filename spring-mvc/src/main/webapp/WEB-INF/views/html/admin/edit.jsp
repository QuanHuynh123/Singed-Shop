<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/admin"/> 
<c:url var="newAPI" value="/api/new"/>
<c:url var="editNewURL" value="/admin/edit"/> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate" />
	<link rel="stylesheet" href="<c:url value='/static/css/admin.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/css/edit.css'/>">
	<link rel="stylesheet" href="<c:url value='/static/icon/themify-icons/themify-icons.css'/>">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<title>SINGED-SHOP</title>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
 <div id="content">
 		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">
  				${message}
			</div>
		</c:if>
        <h1 class="title_edit">Thông tin sản phẩm</h1>
        
        <form:form role="form" id="formSubmit" modelAttribute="product">
            <label for="name_edit">Tên sản phẩm:</label>
            <form:input id="name_edit" path="nameProduct"/><br>

            <label for="quanty_edit">Số lượng:</label>
            <form:input id="quanty_edit" path="quantity"/><br>
            
            <div class="div_img_edit">
                <label class="" for="thumbnail">Ảnh:</label>
                <div class="img_edit">
                    <input type="file" class="" id="thumbnail" name="image"/>
                </div>
             </div><br>

            <label for="price_edit">Giá:</label>
            <form:input id="price_edit" path="price"/><br>

            <label for="describe_edit">Mô tả:</label><br>
            <form:textarea id="describe_edit" path="describe" rows="4" cols="50"></form:textarea><br>

            <label for="style_edit">Phong cách:</label>
            <select id="style_edit" name="idStyle">
            	<option value="">-- Chọn thể loại --</option>
            	<c:forEach var="item" items="${style}">
                	<option value="${item.idStyle }">${item.nameStyle}</option>
                </c:forEach>
            </select><br>  
            
            
           <label for="category_edit">Loại: ${idProduct} </label>
            <form:select id="category_edit" path="category">
                <form:option value="0" label=" -- Chọn loại -- "/>
                <form:options items="${categoryList }"/>
            </form:select>  
           
            <br><br>
			<form:hidden path="idProduct" id="newIdProduct"/>
			<c:if test="${not empty idProduct }">
				<button type="button" value="submit" id="btnAddOrUpdateNew"><i>Cập nhật bài viết</i></button>
			</c:if>
			<c:if test="${empty idProduct }">
            	<button type="button" value="submit" id="btnAddOrUpdateNew"><i>Thêm bài viết</i></button>
            </c:if>
        </form:form>
        </div>
      </div>
      
      <script>
      // Call API bằng ajax
      
    	if (typeof jQuery == 'undefined') {
        	console.log("jQuery is not loaded!");
    	} else {
        	console.log("jQuery is loaded!");
    	}
	</script>
      
      <script>
      	$('#btnAddOrUpdateNew').click(function (e) {
  	    e.preventDefault();
  	    var data = {};
  	    var formData = $('#formSubmit').serializeArray();
  	    $.each(formData, function (i, v) {
              data[""+v.name+""] = v.value;
          });
			    var id = $('#newIdProduct').val();  		
			    if (id == 0 ) id = ""; // do idProduct là kiểu int, không thể gán null, giá trị mặc định là 0
			    
			    if (id == "") {
			    	addNew(data);
			    } else {
			    	console.log("haha" + data);
			    	updateNew(data);
			    }
			});
			
			function addNew(data){
				$.ajax({
		            url: '${newAPI}',
		            type: 'POST',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${editNewURL}?" + "&message=insert_success";
		            },
		            error: function (error) {
		            	window.location.href = "${editNewURL}?" + "&message=error_system";
		            }
		        });
			};
			
			function updateNew(data){
				$.ajax({
		            url: '${newAPI}',
		            type: 'PUT',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${newURL}?" + "&message=update_success";
		            },
		            error: function (error) {
		            	window.location.href = "${editNewURL}?" + "&message=error_system";
		            }
		        });
			}
      </script>
</body>
</html>