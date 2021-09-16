<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="page-heading">
    <h1 class="page-title">Thêm mới nhà xuất bản</h1>
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
            <form:form method="POST" action="admin/publisher/save" modelAttribute="publisher">
                <div class="form-group">
                    <form:label path="name">Tên nhà sản xuất</form:label>
                    <form:input path="name" type="text" class="form-control" ></form:input>
                </div>
                <div class="form-group">
                    <form:label path="address" >Địa chỉ</form:label>
                    <form:input path="address" type="text" class="form-control" ></form:input>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>
