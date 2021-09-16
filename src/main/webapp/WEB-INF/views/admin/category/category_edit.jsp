<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-heading">
    <h1 class="page-title">Chỉnh sửa thể loại sách</h1>
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
            <form:form method="POST" action="/admin/category/update" modelAttribute="category">
                <form:input path="id" value="${category.id}" type="hidden"></form:input>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="name">Tên thể loại sách</form:label>
                            <form:input path="name" type="text" class="form-control" value="${category.name}"></form:input>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="status">Hiển thị</form:label>
                            <form:select path="status" cssClass="form-control">
                                <c:if test="${category.status == 0}">
                                    <form:option value="0" label="Không"/>
                                    <form:option value="1" label="Có"/>
                                </c:if>
                                <c:if test="${category.status == 1}">
                                    <form:option value="1" label="Có"/>
                                    <form:option value="0" label="Không"/>
                                </c:if>
                            </form:select>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cập nhật</button>
            </form:form>
        </div>
    </div>
</div>
