<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "com.webbansach.util.SecurityUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Account</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->
    <div class="page-content">
        <div class="dashboard">
            <div class="container">
                <div class="row">
                    <aside class="col-md-3 col-lg-2">
                        <ul class="nav nav-dashboard flex-column mb-3 mb-md-0">
                            <li class="nav-item">
                                <a class="nav-link" href="/tai-khoan/thong-tin" ><i class="fa fa-user-circle"></i> Tài khoản</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/tai-khoan/don-hang" ><i class="fa fa-history"></i> Lịch sử mua hàng</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/dang-xuat"><i class="fa fa-sign-out"></i> Đăng xuất</a>
                            </li>
                        </ul>
                    </aside><!-- End .col-lg-3 -->
                    <div class="col-md-9 col-lg-10">
                        <div class="main-account">
                            <sec:authorize access="isAuthenticated()">
                                <form:form method="POST" action="/tai-khoan/cap-nhat" enctype="multipart/form-data" modelAttribute="user">
                                    <p style="font-size: 20px"><strong>Thông tin tài khoản</strong></p>
                                    <div class="row" style="border: rgb(206 205 206/47%) 1px solid; margin-bottom: 20px">
                                        <div class="col-md-6">
                                            <img src="/resources/book_images/${userDetail.avatar}" id="imgProduct" width="90px" height="90px" style="border-radius: 50%; display: inline-block">
                                            <label for="inputImage" style="margin-left: 20px" class="btn btn-secondary">Thay ảnh đại diện</label>
                                            <input type="file" name="imgAvatar" id="inputImage" hidden="true">
                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Họ và tên</strong></p>
                                            <form:input path="id" type="hidden"  class="form-control" value="${userDetail.id}"></form:input>
                                            <form:input path="name" type="text" class="form-control" value="${userDetail.name}"></form:input>
                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Email</strong> </p>
                                            <form:input path="email" type="text" class="form-control" value="${userDetail.email}"></form:input>

                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Số điện thoại</strong></p>
                                            <form:input path="phone" type="text" class="form-control" value="${userDetail.phone}"></form:input>

                                        </div>
                                        <div class="col-md-12">
                                            <p><strong>Địa chỉ</strong></p>
                                            <form:input path="address" type="text" class="form-control" value="${userDetail.address}"></form:input>
                                        </div>
                                    </div>
                                    <p style="font-size: 20px"><strong>Thay đổi mật khẩu</strong></p>
                                    <div class="row" style="border: rgb(206 205 206 / 47%) 1px solid; margin-bottom: 20px">
                                        <div class="col-md-12">
                                            <label>Mật khẩu hiện tại</label>
                                            <input type="password" class="form-control" width="394px">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Mật khẩu mới</label>
                                            <input type="password" class="form-control" >
                                        </div>
                                        <div class="col-md-6">
                                            <label>Nhập lại mật khẩu mới</label>
                                            <input type="password" class="form-control" >
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-outline-primary-2">
                                        <span>CẬP NHẬT</span>
                                        <i class="icon-long-arrow-right"></i>
                                    </button>
                                </form:form>
                            </sec:authorize>
                        </div><!-- .End .tab-pane -->
                    </div><!-- End .col-lg-9 -->

                </div>
            </div><!-- End .container -->
        </div><!-- End .dashboard -->
    </div><!-- End .page-content -->
</main>
