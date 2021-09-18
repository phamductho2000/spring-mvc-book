<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Danh sách khách hàng</h1>
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
                <input type="text" placeholder="Nhập tên thành viên" class="form-control" id="inputKeyUser">
            </div>
            <div class="item-flex2">
                <select class="form-control" id="statusUser">
                    <option value="-1" label="Trạng thái">
                    <option value="0" label="Không hoạt động">
                    <option value="1" label="Hoạt động">
                    </option>
                </select>
            </div>
            <div class="item-flex2">
                <select class="form-control" id="roleUser">
                    <option value="" label="Vai trò">
                    <option value="EMPLOYEE" label="Nhân viên">
                    <option value="ADMIN" label="Admin">
                    </option>
                </select>
            </div>
            <div class="item-flex2">
                <button type="submit" class="btn btn-primary" onclick="searchUser()"><i class="fa fa-search" style="padding-right: 4px;"></i>Tìm kiếm</button>
            </div>
        </div>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head" style="justify-content: flex-end">
            <a href="/admin/user/new"  style="margin-right: 5px;" class="btn btn-primary" ><i class="fa fa-plus" style="padding-right: 4px;"></i>THÊM MỚI</a>
            <button type="button"  class="btn btn-danger" onclick=""><i class="fa fa-trash" style="padding-right: 4px"></i>XÓA</button>
        </div>
        <div class="ibox-body">
            <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th></th>
                    <th>Avatar</th>
                    <th>Tên</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Trạng thái</th>
                    <th>Ngày cập nhật</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${ListUser}">
                    <tr>
                        <td>
                            <label class="ui-checkbox">
                                <input type="checkbox">
                                <span class="input-span"></span>
                            </label>
                        </td>
                        <td>
                            <img src="/resources/book_images/${item.avatar}" height="100px"; width="100px"/>
                        </td>
                        <td>${item.name}</td>
                        <td>${item.username}</td>
                        <td>${item.email}</td>
                        <td>
                            <c:if test="${item.status == 1}">
                                <span class="badge badge-success">Hoạt động</span>
                            </c:if>
                            <c:if test="${item.status == 0}">
                                <span class="badge badge-danger">Không hoạt động</span>
                            </c:if>
                        </td>
                        <td>
                            <c:set value="${item.updated_date}" var="dateString" />
                            <fmt:parseDate value="${dateString}" var="dateObject"
                                           pattern="yyyy-MM-dd HH:mm:ss" />

                            <b><fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></b>
                            <b><fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></b>
                        </td>
                        <td>
                            <a href="/admin/user/edit/${item.id}" class="btn btn-default btn-xs m-r-5" data-toggle="tooltip" data-original-title="Edit"><i class="fa fa-pencil font-14"></i></a>
                            <button class="btn btn-default btn-xs" data-toggle="tooltip" data-original-title="Delete" onclick="removeCustomer(${item.id})"><i class="fa fa-trash font-14"></i></button>
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
