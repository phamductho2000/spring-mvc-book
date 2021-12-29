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

                        <div class="main-account">
                            <sec:authorize access="isAuthenticated()">
                                <form:form method="POST" action="/tai-khoan/cap-nhat" enctype="multipart/form-data" modelAttribute="user">
                                    <p style="font-size: 20px"><strong>Thông tin tài khoản</strong></p>
                                    <div class="row" style="border: rgb(206 205 206/47%) 1px solid; margin-bottom: 20px; padding: 10px 10px 10px">
                                        <div class="col-md-6">
                                            <img src="/resources/book_images/${userDetail.avatar}" id="imgProduct" width="90px" height="90px" style="border-radius: 50%; display: inline-block">
                                            <label for="inputImage" style="margin-left: 20px" class="btn btn-secondary">Thay ảnh đại diện</label>
                                            <input type="file" name="imgAvatar" id="inputImage" hidden="true">
                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Họ và tên</strong></p>
                                            <form:input path="id" type="hidden"  class="form-control" value="${userDetail.id}"></form:input>
                                            <div class="form-group">
                                                <form:input path="name" type="text" class="form-control" value="${userDetail.name}"></form:input>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Email</strong> </p>
                                            <form:input path="email" type="text" class="form-control" value="${userDetail.email}"></form:input>

                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Số điện thoại</strong></p>
                                            <form:input path="phone" type="text" class="form-control" value="${userDetail.phone}"></form:input>

                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>Địa chỉ</strong></p>
                                            <form:input path="address" type="text" class="form-control" value="${userDetail.address}"></form:input>
                                        </div>

                                        <div class="col-md-6">
                                            <label>Mật khẩu mới</label>
                                            <form:input path="password" type="password" class="form-control" ></form:input>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-outline-primary-2">
                                        <span>CẬP NHẬT</span>
                                        <i class="icon-long-arrow-right"></i>
                                    </button>
                                </form:form>
                            </sec:authorize>
                        </div><!-- .End .tab-pane -->


                </div>
            </div><!-- End .container -->
        </div><!-- End .dashboard -->
    </div><!-- End .page-content -->
</main>
