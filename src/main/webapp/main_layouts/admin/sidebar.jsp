<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import = "com.webbansach.util.SecurityUtils"%>
<nav class="page-sidebar" id="sidebar">
    <div id="sidebar-collapse">
        <div class="admin-block d-flex">
            <div>
                <img src="/resources/admin/assets/img/admin-avatar.png" width="45px" />
            </div>
            <sec:authorize access="isAuthenticated()">
                <div class="admin-info">
                    <div class="font-strong"><%= SecurityUtils.getPrincipal().getFullName() %></div><small>Administrator</small>
                </div>
            </sec:authorize>
        </div>
        <ul class="side-menu metismenu">
            <li>
                <a class="active" href="/admin/home"><i class="sidebar-item-icon fa fa-th-large"></i>
                    <span class="nav-label">Dashboard</span>
                </a>
            </li>
            <li class="heading">FEATURES</li>
            <li>
                <a href="/admin/book"><i class="sidebar-item-icon fa fa-product-hunt"></i>
                    <span class="nav-label">Sản phẩm</span>
                </a>
            </li>
            <li>
                <a href="/admin/category"><i class="sidebar-item-icon fa fa-list-alt"></i>
                    <span class="nav-label">Danh mục</span>
                </a>
            </li>
            <li>
                <a href="/admin/publisher"><i class="sidebar-item-icon fa fa-industry"></i>
                    <span class="nav-label">Nhà xuất bản</span>
                </a>
            </li>
            <li>
                <a href="/admin/order"><i class="sidebar-item-icon fa fa-shopping-cart"></i>
                    <span class="nav-label">Hóa đơn</span>
                </a>
            </li>
            <li>
                <a href="/admin/customer"><i class="sidebar-item-icon fa fa-user"></i>
                    <span class="nav-label">Khách hàng</span>
                </a>
            </li>
            <li>
                <a href="/admin/voucher"><i class="sidebar-item-icon fa fa-tags"></i>
                    <span class="nav-label">Voucher</span>
                </a>
            </li>
            <sec:authorize access="hasAnyRole('EMPLOYEE,ADMIN')">
            <li>
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
            <li>
                <a href="/admin/report"><i class="sidebar-item-icon fa fa-calendar"></i>
                    <span class="nav-label">Báo cáo</span>
                </a>
            </li>
        </ul>
    </div>
</nav>