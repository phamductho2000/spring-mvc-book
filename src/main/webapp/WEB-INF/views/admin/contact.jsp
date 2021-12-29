<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-heading">
    <h1 class="page-title">Cấu hình thông tin website</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">Form Validation</li>
    </ol>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head">
            <div class="ibox-title">Basic Validation</div>
            <div class="ibox-tools">
                <a class="ibox-collapse"><i class="fa fa-minus"></i></a>
            </div>
        </div>
        <div class="ibox-body">
            <form:form action="/admin/setting/update"  method="post"  modelAttribute="contact">
                <form:input path="id" type="hidden" value="${contact.id}"></form:input>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Địa chỉ</label>
                    <div class="col-sm-10">
                        <form:input path="address" cssClass="form-control" type="text" value="${contact.address}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <form:input path="email" cssClass="form-control" type="text" value="${contact.email}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Số điện thoại</label>
                    <div class="col-sm-10">
                        <form:input path="phone" cssClass="form-control" type="text" value="${contact.phone}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Link google map</label>
                    <div class="col-sm-10">
                        <form:input path="link_map" cssClass="form-control" type="text" value="${contact.link_map}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Link fanpage</label>
                    <div class="col-sm-10">
                        <form:input path="link_fb" cssClass="form-control" type="text" value="${contact.link_fb}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Link youtube</label>
                    <div class="col-sm-10">
                        <form:input path="link_youtube" cssClass="form-control" type="text" value="${contact.link_youtube}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Link instagram</label>
                    <div class="col-sm-10">
                        <form:input path="link_insta" cssClass="form-control" type="text" value="${contact.link_insta}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Link twitter</label>
                    <div class="col-sm-10">
                        <form:input path="link_twitter" cssClass="form-control" type="text" value="${contact.link_twitter}"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10 ml-sm-auto">
                        <button class="btn btn-info" type="submit">Cập nhật</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
