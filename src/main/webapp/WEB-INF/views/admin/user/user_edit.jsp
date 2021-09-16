<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-heading">
    <h1 class="page-title">Chỉnh sủa thành viên</h1>
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
            <form:form method="POST" action="/admin/user/save" enctype="multipart/form-data" modelAttribute="customer">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="name">Họ và tên</form:label>
                            <form:input path="name" type="text" class="form-control" value="${user.name}"></form:input>
                            <form:input path="id" type="hidden" class="form-control" value="${user.id}"></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="phone" >Số điện thoại</form:label>
                            <form:input path="phone" type="text" class="form-control" value="${user.phone}"></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="address" >Địa chỉ</form:label>
                            <form:input path="address" type="text" class="form-control" value="${user.address}"></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="email" >Email</form:label>
                            <form:input path="email" type="text" class="form-control" value="${user.email}"></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="username" >Username</form:label>
                            <form:input path="username" type="text" readonly="true" class="form-control" value="${user.username}"></form:input>
                        </div>
                        <div class="form-group">
                            <form:label path="password" >Password</form:label>
                            <form:input path="password" type="password" class="form-control" value=""></form:input>
                        </div>

                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <img src="/resources/book_images/${user.avatar}" width="130" height="135" id="imgProduct" style="display: inline-block">
                            <label for="inputImage" path="image" class="btn btn-primary">Chọn avatar</label>
                            <input type="file"  value="Upload File"  hidden="true" name="file" id="inputImage"/>
                        </div>
                        <div class="form-group">
                            <label>Phân quyền</label>
                            <c:forEach var="item" items="${roles}">
                                <c:if test="${user.roles.contains(item.code)}">
                                    <div class="form-check form-switch">
                                        <input class="form-check-input" name="checkRole" type="checkbox" value="${item.code}" id="flexSwitchCheckDefault1" checked>
                                        <label class="form-check-label" for="flexSwitchCheckDefault1">${item.name}</label>
                                    </div>
                                </c:if>
                                <c:if test="${user.roles.contains(item.code) == false}">
                                <div class="form-check form-switch">
                                    <input class="form-check-input" name="checkRole" type="checkbox" value="${item.code}" id="flexSwitchCheckDefault">
                                    <label class="form-check-label" for="flexSwitchCheckDefault">${item.name}</label>
                                </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">CẬP NHẬT</button>
            </form:form>
        </div>
    </div>
</div>
