<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-heading">
    <h1 class="page-title">Chỉnh sửa voucher</h1>
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
            <form:form method="POST" action="/admin/voucher/save" modelAttribute="voucher">
                <form:input path="id" value="${voucher.id}" type="hidden"></form:input>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="code">Code giảm giá</form:label>
                            <form:input path="code" type="text" class="form-control" value="${voucher.code}"></form:input>
                        </div>
                        <div class="form-group">
                            <form:label path="discount">Giảm giá (%)</form:label>
                            <form:input path="discount" type="number" class="form-control" value="${voucher.discount}"></form:input>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group" id="date_1">
                            <label class="font-normal"></label>
                            <div class="input-group date">
                                <span class="input-group-addon bg-white"><i class="fa fa-calendar"></i></span>
                                <input class="form-control" type="text" name="expirationDate" value="${voucher.expirationDate.toString().replace("-", "/")}">
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="status">Trạng thái</form:label>
                            <form:select path="status" cssClass="form-control">
                                <c:if test="${voucher.status == 0}">
                                    <form:option value="0" label="Không hoạt động"/>
                                    <form:option value="1" label="Hoạt động"/>
                                </c:if>
                                <c:if test="${voucher.status == 1}">
                                    <form:option value="1" label="Hoạt động"/>
                                    <form:option value="0" label="Không hoạt động"/>
                                </c:if>
                            </form:select>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <form:label path="description">Mổ tả</form:label>
                            <form:input path="description" type="text" class="form-control" value="${voucher.description}"></form:input>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cập nhật</button>
            </form:form>
        </div>
    </div>
</div>
