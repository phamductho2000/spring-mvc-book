<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
    <h1 class="page-title">Báo cáo doanh thu</h1>
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
                    <option value="0" label=" Chưa thanh toán"/>
                    <option value="1" label=" Đang giao"/>
                    <option value="2" label=" Hoàn thành"/>

                </select>
            </div>
            <div class="form-group" id="date_5">
                <div class="input-daterange input-group" id="datepicker">
                    <input class="input-sm form-control" id="startDate" type="text" name="start" placeholder="Chọn ngày bắt đầu" value="">
                    <span class="input-group-addon p-l-10 p-r-10">to</span>
                    <input class="input-sm form-control" id="endDate" type="text" placeholder="Chọn ngày kết thúc" name="end" value="">
                </div>
            </div>
            <button type="button" class="btn btn-primary" onclick="searchOrder('/admin/report/search')"><i class="fa fa-search" style="padding-right: 4px;"></i>Tìm kiếm</button>
        </div>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head" style="justify-content: flex-end">
            <div class="item-flex">
                <a href="#" onclick="searchReportByCurrentDay()">Hôm nay</a>
            </div>
            <div class="item-flex">
                <a href="#" onclick="searchReportByPreviousDay()">Hôm qua</a>
            </div>
            <div class="item-flex">
                <a href="#" id="currentMonth" onclick="searchReportByCurrentMonth()">Trong tháng</a>
            </div>
            <div class="item-flex">
                <a href="#" onclick="searchReportByPreviousMonth()">Tháng trước</a>
            </div>
            <div class="">
                <button onclick="exportExcel()"  style="margin-right: 5px;" class="btn btn-success" ><i class="fa fa-file-excel-o" style="padding-right: 4px; font-size: 17px"></i>Xuất file excel</button>
            </div>
        </div>
        <div class="ibox-body">
            <form:form method="post" action="/admin/report/export-excel" id="formReport" modelAttribute="listOrder">
            <table class="table table-striped table-bordered table-hover" id="example-table" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th colspan="5">TỔNG DOANH THU : <fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice}"/> ₫</th>
                </tr>
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Khách hàng</th>
                    <th>Tổng tiền</th>
                    <th>Tình trạng</th>
                    <th>Ngày tạo</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listOrder.orders}" varStatus="od">
                    <tr>
                        <form:input path="orders[${od.index}].id" type="hidden" value="${item.id}"></form:input>
                        <form:input path="orders[${od.index}].user_name" type="hidden" value="${item.user_name}"></form:input>
                        <form:input path="orders[${od.index}].total_price" type="hidden" value="${item.total_price}"></form:input>
                        <form:input path="orders[${od.index}].status" type="hidden" value="${item.status}"></form:input>
                        <form:input path="orders[${od.index}].created_date" type="hidden" value="${item.created_date}"></form:input>
                        <td>${item.id}</td>
                        <td><a href="">${item.user_name}</a></td>
                        <td><fmt:formatNumber type="number" groupingUsed="true" value="${item.total_price}"/> ₫</td>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form:form>
            <ul id="pagination" class="pagination-sm" style="float: right"></ul>
            <input hidden="true" id="totalPage" value="${totalPage}">
            <input hidden="true" id="currentPage" value="${currentPage}">
        </div>
    </div>
</div>
