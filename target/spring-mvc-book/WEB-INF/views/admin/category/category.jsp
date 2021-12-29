<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Danh sách danh mục</h1>
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
                <input type="text" placeholder="Nhập tên thể loại" class="form-control" id="inputCategoryName">
            </div>
            <div class="item-flex2">
                <button type="button" class="btn btn-primary" onclick="searchCategory()"><i class="fa fa-search" style="padding-right: 4px;"></i>Tìm kiếm</button>
            </div>
        </div>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head">
            <div style="display: flex">
                <div class="m-r-5">
                    <p class="m-t-5">Hiển thị</p>
                </div>
                <div>
                    <select class="form-control" id="limitShowOption" >
                        <option value="10" label="10"/>
                        <option value="30" label="30"/>
                        <option value="50" label="50"/>
                    </select>
                </div>
            </div>
            <div style="justify-content: flex-end">
                <a href="/admin/category/new"  style="margin-right: 5px;" class="btn btn-primary" ><i class="fa fa-plus" style="padding-right: 4px;"></i>THÊM MỚI</a>
                <button type="button"  class="btn btn-danger" id="removeCategories"><i class="fa fa-trash" style="padding-right: 4px"></i>XÓA</button>
            </div>
        </div>
        <div class="ibox-body">
            <table class="table table-striped table-bordered table-hover" id="Datatable" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>
                        <label class="ui-checkbox">
                            <input class="checkId" type="checkbox" id="checkAll" onclick="checkAll()">
                            <span class="input-span"></span>
                        </label>
                    </th>
                    <th>Mã thể loại</th>
                    <th>Tên thể loại</th>
                    <th>Hiển thị</th>
                    <th>Ngày cập nhật</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listCategory}">
                    <tr>
                        <td>
                            <label class="ui-checkbox">
                                <input class="checkId input-check" type="checkbox">
                                <span class="input-span"></span>
                            </label>
                        </td>
                        <td>${item.id}</td>
                        <td><span>${item.name}</span></td>
                        <td>
                            <c:if test="${item.status == 0}">
                                <span class="badge badge-danger">không</span>
                            </c:if>
                            <c:if test="${item.status == 1}">
                                <span class="badge badge-success">có</span>
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
                            <a href="/admin/category/edit/${item.id}" class="btn btn-default btn-xs m-r-5" data-toggle="tooltip" data-original-title="Edit"><i class="fa fa-pencil font-14"></i></a>
                            <button class="btn btn-default btn-xs" data-toggle="tooltip" data-original-title="Delete" onclick="removeCategory(${item.id})"><i class="fa fa-trash font-14"></i></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav id="page_navigation">
                <ul id="pagination" class="pagination-sm" style="float: right"></ul>
                <input hidden="true" id="totalPage" value="${totalPage}">
                <input hidden="true" id="currentPage" value="${currentPage}">
            </nav>
        </div>
    </div>
</div>
