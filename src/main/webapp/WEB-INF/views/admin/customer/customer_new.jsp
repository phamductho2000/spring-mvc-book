<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-heading">
    <h1 class="page-title">Thêm mới thành viên</h1>
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
            <form:form method="POST" action="/admin/customer/save" enctype="multipart/form-data" modelAttribute="customer">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="name">Họ và tên</form:label>
                            <form:input path="name" type="text" class="form-control" ></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="phone" >Số điện thoại</form:label>
                            <form:input path="phone" type="text" class="form-control" ></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="address" >Địa chỉ</form:label>
                            <form:input path="address" type="text" class="form-control" ></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="email" >Email</form:label>
                            <form:input path="email" type="text" class="form-control" ></form:input>
                        </div>

                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <img src="" width="130px" height="135px" id="imgProduct" style="display: inline-block">
                            <label for="inputImage" path="image" class="btn btn-primary">Chọn avatar</label>
                            <input type="file"  value="Upload File"  hidden="true" name="file" id="inputImage"/>
                        </div>
                        <div class="form-group">
                            <form:label path="username" >Username</form:label>
                            <form:input path="username" type="text" class="form-control"></form:input>
                        </div>
                        <div class="form-group">
                            <form:label path="password" >Password</form:label>
                            <form:input path="password" type="password" class="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">THÊM MỚI</button>
            </form:form>
        </div>
    </div>
</div>
