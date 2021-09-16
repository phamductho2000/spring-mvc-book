<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Danh sách nhà xuất bản</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">DataTables</li>
    </ol>
</div>
<div class="" style="margin-top: 30px">
        <div class="search-form" style="display: flex; justify-content: flex-end; height: 33px">
            <div class="item-flex2">
                <input type="text" placeholder="Nhập tên nhà sản xuất" class="form-control" id="inputPublisherName">
            </div>
            <div class="item-flex2">
                <input type="text" placeholder="Nhập địa chỉ nhà sản xuất" class="form-control" id="inputPublisherAddress">
            </div>
            <div class="item-flex2">
                <button type="button" class="btn btn-primary" onclick="searchPublisher()"><i class="fa fa-search" style="padding-right: 4px;"></i>Tìm kiếm</button>
            </div>
        </div>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head" style="justify-content: flex-end">
            <a href="/admin/publisher/new"  style="margin-right: 5px;" class="btn btn-primary" ><i class="fa fa-plus" style="padding-right: 4px;"></i>THÊM MỚI</a>
            <button type="button"  class="btn btn-danger" onclick=""><i class="fa fa-trash" style="padding-right: 4px"></i>XÓA</button>
        </div>
        <div class="ibox-body">
            <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th></th>
                    <th>Mã nhà xuất bản</th>
                    <th>Tên nhà xuất bản</th>
                    <th>Địa chỉ</th>
                    <th>Ngày cập nhật</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listPublisher}">
                    <tr>
                        <td>
                            <label class="ui-checkbox">
                                <input type="checkbox">
                                <span class="input-span"></span>
                            </label>
                        </td>
                        <td>${item.id}</td>
                        <td><a href="">${item.name}</a></td>
                        <td>${item.address}</td>
                        <td>
                            <c:set value="${item.updated_date}" var="dateString" />
                            <fmt:parseDate value="${dateString}" var="dateObject"
                                           pattern="yyyy-MM-dd HH:mm:ss" />

                            <b><fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></b>
                            <b><fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></b>
                        </td>
                        <td>
                            <a href="/admin/publisher/edit/${item.id}" class="btn btn-default btn-xs m-r-5" data-toggle="tooltip" data-original-title="Edit"><i class="fa fa-pencil font-14"></i></a>
                            <button class="btn btn-default btn-xs" data-toggle="tooltip" data-original-title="Delete" onclick="removePublisher(${item.id})"><i class="fa fa-trash font-14"></i></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <ul id="pagination" class="pagination-sm" style="float: right"></ul>
            <input hidden="true" id="totalPage" value="${totalPage}">
            <input hidden="true" id="currentPage" value="${currentPage}">
        </div>
    </div>
</div>
