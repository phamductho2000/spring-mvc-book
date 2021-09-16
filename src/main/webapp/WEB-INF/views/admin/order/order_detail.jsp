<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Chi tiết hóa đơn</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">Invoice</li>
    </ol>
</div>
<div class="page-content fade-in-up">
    <div class="ibox invoice">
        <div class="invoice-header">
            <div class="row">
                <div class="col-6">
                    <div class="invoice-logo">
                        <img src="./assets/img/logos/github-logo.png" height="65px" />
                    </div>
                    <div>
                        <div class="m-b-5 font-bold">Gửi từ</div>
                        <div>Github, Inc.</div>
                        <ul class="list-unstyled m-t-10">
                            <li class="m-b-5">
                                <span class="font-strong">A:</span> Xã Đông Dương, TP Thái Bình</li>
                            <li class="m-b-5">
                                <span class="font-strong">W:</span> tho2022000@gmail.com</li>
                            <li>
                                <span class="font-strong">P:</span> (123) 456-2112</li>
                        </ul>
                    </div>
                </div>
                <div class="col-6 text-right">
                    <div class="clf" style="margin-bottom:30px;">
                        <dl class="row pull-right" style="width:250px;"><dt class="col-sm-6">Invoice Date</dt>
                            <dd class="col-sm-6">10 April 2017</dd><dt class="col-sm-6">Issue Date</dt>
                            <dd class="col-sm-6">30 April 2017</dd><dt class="col-sm-6">Account No.</dt>
                            <dd class="col-sm-6">1450012</dd>
                        </dl>
                    </div>
                    <div>
                        <div class="m-b-5 font-bold">Gửi đến</div>
                        <div>${Order.user_name}</div>
                        <ul class="list-unstyled m-t-10">
                            <li class="m-b-5">${Order.user_address}</li>
                            <li class="m-b-5">emma.johnson@exmail.com</li>
                            <li>${Order.user_phone}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-striped no-margin table-invoice">
            <thead>
            <tr>
                <th>Sản phẩm</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th class="text-right">Thành tiền</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${listDetailOrder}">
                <tr>
                    <td>
                        <div><strong>${item.bookName}</strong></div></td>
                    <td>${item.quantity}</td>
                    <td><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/> ₫</td>
                    <td><fmt:formatNumber type="number" groupingUsed="true" value="${item.total}"/> ₫</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table class="table no-border">
            <thead>
            <tr>
                <th></th>
                <th width="15%"></th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-right">
                <td>Tạm tính:</td>
                <td><fmt:formatNumber type="number" groupingUsed="true" value="${Order.total_price - 30000}"/> ₫</td>
            </tr>
            <tr class="text-right">
                <td>Phí vận chuyển:</td>
                <td><fmt:formatNumber type="number" groupingUsed="true" value="30000"/> ₫</td>
            </tr>
            <tr class="text-right">
                <td class="font-bold font-18">TỔNG:</td>
                <td class="font-bold font-18"><fmt:formatNumber type="number" groupingUsed="true" value="${Order.total_price}"/> ₫</td>
            </tr>
            </tbody>
        </table>
        <div style="display: flex; justify-content: space-between">
            <form action="/admin/order/update" method="post">
                <div style="display: flex; justify-content: start">
                        <input name="id" type="hidden" value="${Order.id}">
                        <select class="form-control" name="statusOrder">
                            <option value="0" label="Đang xử lý"></option>
                            <option value="1" label="Hoàn thành"></option>
                            <option value="2" label="Đang giao"></option>
                            <option value="3" label="Hủy"></option>
                        </select>
                        <span><button type="submit" class="btn btn-primary" style="margin-left: 5px">Cập nhật</button></span>
                </div>
            </form>
            <div>
                <button class="btn btn-info" type="button" onclick="javascript:window.print();"><i class="fa fa-print"></i> Print</button>
            </div>
        </div>
    </div>
    <style>
        .invoice {
            padding: 20px
        }

        .invoice-header {
            margin-bottom: 50px
        }

        .invoice-logo {
            margin-bottom: 50px;
        }

        .table-invoice tr td:last-child {
            text-align: right;
        }
    </style>
</div>