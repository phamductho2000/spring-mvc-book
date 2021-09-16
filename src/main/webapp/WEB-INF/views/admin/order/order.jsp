<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Danh sách hóa đơn</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">DataTables</li>
    </ol>
</div>
<div class="" style="margin-top: 30px">
    <div class="search-form" style="display: flex; justify-content: space-around; height: 33px">
        <div>
            <input type="text" id="idOrder" placeholder="Nhập mã hóa đơn" class="form-control">
        </div>
        <div>
            <select class="form-control" id="statusOrder" name="statusOrder" >
                <option value="-1" label=" Tình trạng đơn hàng"/>
                <option value="0" label=" Đang xử lý"/>
                <option value="1" label=" Hoàn thành"/>
                <option value="2" label=" Đang giao"/>
                <option value="3" label=" Đã hủy"/>
            </select>
        </div>
        <div class="form-group" id="date_5">
            <div class="input-daterange input-group" id="datepicker">
                <input class="input-sm form-control" id="startDate" type="text" name="start" placeholder="Chọn ngày bắt đầu" value="">
                <span class="input-group-addon p-l-10 p-r-10">to</span>
                <input class="input-sm form-control" id="endDate" type="text" placeholder="Chọn ngày kết thúc" name="end" value="">
            </div>
        </div>
        <button type="button" class="btn btn-primary" onclick="searchOrder('/admin/order/search')"><i class="fa fa-search" style="padding-right: 4px;"></i>Tìm kiếm</button>
    </div>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head" style="justify-content: flex-end">
            <button type="button"  class="btn btn-danger" onclick=""><i class="fa fa-trash" style="padding-right: 4px"></i>XÓA</button>
        </div>
        <div class="ibox-body">
            <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th></th>
                    <th>Mã đơn hàng</th>
                    <th>Khách hàng</th>
                    <th>Tổng tiền</th>
                    <th>Tình trạng</th>
                    <th>Ngày tạo</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listOrder}">
                    <tr>
                        <td>
                            <label class="ui-checkbox">
                                <input type="checkbox">
                                <span class="input-span"></span>
                            </label>
                        </td>
                        <td><a href="/admin/order/detail/${item.id}">${item.id}</a></td>
                        <td><a href="">${item.user_name}</a></td>
                        <td>${item.total_price}</td>
                        <c:if test="${item.status == 1}">
                            <td><span class="badge badge-success">Hoàn thành</span></td>
                        </c:if>
                        <c:if test="${item.status == 0}">
                            <td><span class="badge badge-danger">Đang xử lý</span></td>
                        </c:if>
                        <c:if test="${item.status == 2}">
                            <td><span class="badge badge-warning">Đang giao</span></td>
                        </c:if>
                        <c:if test="${item.status == 3}">
                            <td><span class="badge badge-default">Đã hủy</span></td>
                        </c:if>
                        <td>
                            <c:set value="${item.created_date}" var="dateString" />
                            <fmt:parseDate value="${dateString}" var="dateObject"
                                           pattern="yyyy-MM-dd HH:mm:ss" />

                            Date is : <b><fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></b>
                            </br>
                            Time is : <b><fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></b>
                        </td>
                        <td>
                            <a href="/admin/order/detail/${item.id}" class="btn btn-default btn-xs m-r-5" data-toggle="tooltip" data-original-title="Edit"><i class="fa fa-pencil font-14"></i></a>
                            <button class="btn btn-default btn-xs" data-toggle="tooltip" data-original-title="Delete" onclick="removeBook(${item.id})"><i class="fa fa-trash font-14"></i></button>
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
