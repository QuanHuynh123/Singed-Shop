<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Singedshop.security.utils.SecurityUtils" %>
            <div id="home-admin">
            <div id="menu">
                <div id="intro-admin">
                    <div id="row-intro">
                        <h1 id="title-admin">Admin</h1>
                        <img id="icon" src="<c:url value='/static/img/iconsinged.webp' />">
                    </div>
                    <h3 id="hello-admin" >Chào  <%= SecurityUtils.getNameUser() %></h3>
                </div>
        
                <div id="search">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>
                <div id="div-list-menu">
                    <ul class="menu">
                        <li><i class="fa-solid fa-house-lock icon-list-menu"></i></i> <a
                            href="<c:url value="/admin"/>">Home</a></li>
                        <li><i class="fa-solid fa-chart-line icon-list-menu"></i> <a
                            href="#">Dashboard</a></li>
                        <li><i class="fa-solid fa-file icon-list-menu"></i> <a
                            href="<c:url value="/trang-chu"/>">Pages</a></li>
                        <li><i class="fa-solid fa-file-invoice icon-list-menu"></i> <a
                            href="<c:url value="/admin/bill"/>">Duyệt đơn</a></li>
                        <li><i class="fa-solid fa-gear icon-list-menu"></i> <a
                            href="#">Config</a></li>
                        <li><i class="fa-solid fa-gear icon-list-menu"></i> <a
                            href="<c:url value="/logout"/>">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>