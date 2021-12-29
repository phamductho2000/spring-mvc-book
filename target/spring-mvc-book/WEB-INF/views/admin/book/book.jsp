<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Danh sách sách</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">DataTables</li>
    </ol>
</div>
<div class="" style="margin-top: 30px">
    <div class="search-form" style="display: flex; justify-content: space-around; height: 33px; padding-right: 9px">
            <div >
                <input type="text" style="width: 200px" class="form-control" name="nameOrId" id="nameOrId" placeholder="Nhập tên sách">
            </div>
            <div>
                <select class="form-control" name="status" id="s_status" style="width: 200px">
                    <option value="-1" label="Chọn tình trạng"/>
                        <option value="0" label="Hết hàng">
                        <option value="1" label="Còn hàng">
                        <option value="2" label="Ngừng kinh doanh">
                    </option>
                </select>
            </div>
            <div>
                <select class="form-control" name="categoryId" id="s_cateId" style="width: 200px">
                    <option value="0" label="Chọn danh mục"/>
                    <c:forEach items="${listCategory}" var="item">
                        <option value="${item.id}" label="${item.name}"></option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <select class="form-control" name="publisherId" id="s_publId" style="width: 200px">
                    <option value="0" label="Chọn nhà xuất bản"/>
                    <c:forEach items="${listPublisher}" var="item">
                        <option value="${item.id}" label="${item.name}"></option>
                    </c:forEach>
                </select>
            </div>
            <div >
                <button onclick="searchBook()" class="btn btn-primary" ><i class="fa fa-search" style="padding-right: 4px;"></i>Tìm kiếm</button>
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
                <a href="/admin/book/new"  style="margin-right: 5px;" class="btn btn-primary" ><i class="fa fa-plus" style="padding-right: 4px;"></i>THÊM MỚI</a>
                <button type="button"  class="btn btn-danger" id="removeBooks"><i class="fa fa-trash" style="padding-right: 4px"></i>XÓA</button>
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
                    <th hidden="true" >ID</th>
                    <th>Tên</th>
                    <th>Tác giả</th>
                    <th>Đơn giá</th>
                    <th>Tình trạng</th>
                    <th>Ngày cập nhật</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listBook}">
                <tr>
                    <td>
                        <label class="ui-checkbox">
                            <input class="checkId input-check" type="checkbox" id="${item.id}">
                            <span class="input-span"></span>
                        </label>
                    </td>
                    <td hidden="true">${item.id}</td>
                    <td><a href="/admin/book/detail/${item.id}">${item.name}</a></td>
                    <td>${item.author}</td>
                    <td>
                        <fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/> ₫
                    </td>
                        <c:if test="${item.status == 0}">
                            <td><span class="badge badge-danger">Hết hàng</span></td>
                        </c:if>
                        <c:if test="${item.status == 1}">
                            <td><span class="badge badge-success">Còn hàng</span></td>
                        </c:if>
                        <c:if test="${item.status == 2}">
                            <td><span class="badge badge-default">Ngừng kinh doanh</span></td>
                        </c:if>
                    <td>
                        <c:set value="${item.updated_date}" var="dateString" />
                        <fmt:parseDate value="${dateString}" var="dateObject"
                                       pattern="yyyy-MM-dd HH:mm:ss" />

                        <b><fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></b>
                        <b><fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></b>
                    </td>
                    <td>
                        <a href="/admin/book/edit/${item.id}/${item.publisher_id}/${item.category_id}" class="btn btn-default btn-xs m-r-5" data-toggle="tooltip" data-original-title="Edit"><i class="fa fa-pencil font-14"></i></a>
                        <button class="btn btn-default btn-xs" data-toggle="tooltip" data-original-title="Delete" onclick="removeBook(${item.id})"><i class="fa fa-trash font-14"></i></button>
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
