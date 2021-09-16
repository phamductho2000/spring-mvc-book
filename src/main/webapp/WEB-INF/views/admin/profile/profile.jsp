<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
    <h1 class="page-title">Profile</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">Thông tin tài khoản</li>
    </ol>
</div>
<div class="page-content fade-in-up">
    <div class="row">
        <div class="col-lg-3 col-md-4">
            <div class="ibox">
                <div class="ibox-body text-center">
                    <div class="m-t-20">
                        <img class="img-circle" src="/resources/book_images/${userDetail.avatar}" />
                    </div>
                    <h5 class="font-strong m-b-10 m-t-10">${userDetail.name}</h5>
                </div>
            </div>
        </div>
        <div class="col-lg-9 col-md-8">
            <div class="ibox">
                <div class="ibox-body">
                    <ul class="nav nav-tabs tabs-line">
                        <li class="nav-item">
                            <a class="nav-link active" href="#tab-1" data-toggle="tab"><i class="ti-settings"></i> Settings</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#tab-2" data-toggle="tab"><i class="ti-announcement"></i> Feeds</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="tab-1">
                            <form:form action="/admin/profile/update" method="post" modelAttribute="user">
                                <div class="form-group">
                                    <form:label path="">Họ và tên</form:label>
                                    <form:input class="form-control" type="text" placeholder="Họ và tên" path="name" value="${userDetail.name}"></form:input>
                                </div>
                                <div class="form-group">
                                    <form:label path="email">Email</form:label>
                                    <form:input class="form-control" type="text" placeholder="Địa chỉ email" path="email" value="${userDetail.email}"></form:input>
                                </div>
                                <div class="form-group">
                                    <form:label path="phone">Số điện thoại</form:label>
                                    <form:input class="form-control" type="number" placeholder="Số điện thoại" path="phone" value="${userDetail.phone}"></form:input>
                                </div>
                                <div class="form-group">
                                    <form:label path="password">Mật khẩu</form:label>
                                    <form:input class="form-control" type="password" placeholder="Password" path="password"></form:input>
                                </div>
                                <div class="form-group">
                                    <button class="btn btn-default" type="submit">Cập nhật</button>
                                </div>
                            </form:form>
                        </div>
                        <div class="tab-pane fade" id="tab-2">
                            <h5 class="text-info m-b-20 m-t-20"><i class="fa fa-bullhorn"></i> Latest Feeds</h5>
                            <ul class="media-list media-list-divider m-0">
                                <li class="media">
                                    <div class="media-img"><i class="ti-user font-18 text-muted"></i></div>
                                    <div class="media-body">
                                        <div class="media-heading">New customer <small class="float-right text-muted">12:05</small></div>
                                        <div class="font-13">Lorem Ipsum is simply dummy text.</div>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-img"><i class="ti-info-alt font-18 text-muted"></i></div>
                                    <div class="media-body">
                                        <div class="media-heading text-warning">Server Warning <small class="float-right text-muted">12:05</small></div>
                                        <div class="font-13">Lorem Ipsum is simply dummy text.</div>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-img"><i class="ti-announcement font-18 text-muted"></i></div>
                                    <div class="media-body">
                                        <div class="media-heading">7 new feedback <small class="float-right text-muted">Today</small></div>
                                        <div class="font-13">Lorem Ipsum is simply dummy text.</div>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-img"><i class="ti-check font-18 text-muted"></i></div>
                                    <div class="media-body">
                                        <div class="media-heading text-success">Issue fixed <small class="float-right text-muted">12:05</small></div>
                                        <div class="font-13">Lorem Ipsum is simply dummy text.</div>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-img"><i class="ti-shopping-cart font-18 text-muted"></i></div>
                                    <div class="media-body">
                                        <div class="media-heading">7 New orders <small class="float-right text-muted">12:05</small></div>
                                        <div class="font-13">Lorem Ipsum is simply dummy text.</div>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-img"><i class="ti-reload font-18 text-muted"></i></div>
                                    <div class="media-body">
                                        <div class="media-heading text-danger">Server warning <small class="float-right text-muted">12:05</small></div>
                                        <div class="font-13">Lorem Ipsum is simply dummy text.</div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <style>
        .profile-social a {
            font-size: 16px;
            margin: 0 10px;
            color: #999;
        }

        .profile-social a:hover {
            color: #485b6f;
        }

        .profile-stat-count {
            font-size: 22px
        }
    </style>
</div>