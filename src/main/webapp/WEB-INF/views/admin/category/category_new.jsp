<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="page-heading">
    <h1 class="page-title">Thêm mới danh mục</h1>
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
            <form:form method="POST" action="/admin/category/save" modelAttribute="category">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="name">Tên thể loại sách</form:label>
                            <form:input path="name" type="text" class="form-control" ></form:input>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <form:label path="status">Hiển thị</form:label>
                            <form:select path="status" cssClass="form-control">
                                <form:option value="0" label="Không"/>
                                <form:option value="1" label="Có"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Thêm mới</button>
            </form:form>
        </div>
    </div>
</div>
