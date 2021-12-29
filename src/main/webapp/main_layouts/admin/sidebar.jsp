<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import = "com.webbansach.util.SecurityUtils"%>
<nav class="page-sidebar" id="sidebar">
    <div id="sidebar-collapse">
        <div class="admin-block d-flex">
            <sec:authorize access="isAuthenticated()">
                <div>
                    <img src="/resources/book_images/<%= SecurityUtils.getPrincipal().getAvatar() %>" width="45px" />
                </div>
                <div class="admin-info">
                    <div class="font-strong"><%= SecurityUtils.getPrincipal().getFullName() %></div><small>Administrator</small>
                </div>
            </sec:authorize>
        </div>
        <ul class="side-menu metismenu">
            <li class="item-sidebar">
                <a class="active" href="/admin/home"><i class="sidebar-item-icon fa fa-th-large"></i>
                    <span class="nav-label">Dashboard</span>
                </a>
            </li>
            <li class="heading">FEATURES</li>
            <li class="item-sidebar">
                <a href="/admin/book?page=1&limit=10"><i class="sidebar-item-icon fa fa-product-hunt"></i>
                    <span class="nav-label">Sản phẩm</span>
                </a>
            </li>
            <li class="item-sidebar">
                <a href="/admin/category?page=1&limit=10"><i class="sidebar-item-icon fa fa-list-alt"></i>
                    <span class="nav-label">Danh mục</span>
                </a>
            </li>
            <li class="item-sidebar">
                <a href="/admin/publisher?page=1&limit=10"><i class="sidebar-item-icon fa fa-industry"></i>
                    <span class="nav-label">Nhà xuất bản</span>
                </a>
            </li>
            <li class="item-sidebar">
                <a href="/admin/order?page=1&limit=10"><i class="sidebar-item-icon fa fa-shopping-cart"></i>
                    <span class="nav-label">Hóa đơn</span>
                </a>
            </li>
            <li class="item-sidebar">
                <a href="/admin/customer?page=1&limit=10"><i class="sidebar-item-icon fa fa-user"></i>
                    <span class="nav-label">Khách hàng</span>
                </a>
            </li>
            <li class="item-sidebar">
                <a href="/admin/voucher?page=1&limit=10"><i class="sidebar-item-icon fa fa-tags"></i>
                    <span class="nav-label">Voucher</span>
                </a>
            </li>
            <sec:authorize access="hasAnyRole('EMPLOYEE,ADMIN')">
            <li class="item-sidebar">
                <a href="javascript:;"><i class="sidebar-item-icon fa fa-user-secret"></i>
                    <span class="nav-label">Quản trị viên</span><i class="fa fa-angle-left arrow"></i></a>
                <ul class="nav-2-level collapse">
                    <li>
                        <a href="/admin/user">Thành viên</a>
                    </li>
                    <li>
                        <a href="mail_view.html">Quyền</a>
                    </li>
                    <li>
                        <a href="mail_compose.html">Compose mail</a>
                    </li>
                </ul>
            </li>
            </sec:authorize>
            <li class="item-sidebar">
                <a href="/admin/report?page=1&limit=10"><i class="sidebar-item-icon fa fa-calendar"></i>
                    <span class="nav-label">Báo cáo</span>
                </a>
            </li>
            <li class="item-sidebar">
                <a href="/admin/setting"><i class="sidebar-item-icon fa fa-cogs"></i>
                    <span class="nav-label">Setting</span>
                </a>
            </li>
        </ul>
    </div>
</nav>