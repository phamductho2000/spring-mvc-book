<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.webbansach.util.SecurityUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Checkout</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content" >
        <div class="checkout">
            <div class="container">
                <form action="/dat-hang" method="post">
                    <div class="row">
                        <div class="col-lg-8">
                            <sec:authorize access="isAuthenticated()">
                            <h2 class="checkout-title">Đặt hàng</h2><!-- End .checkout-title -->
                                <input type="text" hidden="true" name="userId" value="<%= SecurityUtils.getPrincipal().getId() %>">
                            <div class="row">

                                <div class="col-sm-6">
                                    <label>Thông tin người nhận *</label>
                                    <input type="text" class="form-control" placeholder="Họ và tên" required value="<%= SecurityUtils.getPrincipal().getFullName() %>">
                                </div><!-- End .col-sm-6 -->

                                <div class="col-sm-6">
                                    <br>
                                    <input type="text" class="form-control" placeholder="Số điện thoại" required value="<%= SecurityUtils.getPrincipal().getPhone() %>">
                                </div><!-- End .col-sm-6 -->
                            </div><!-- End .row -->

                            <label>Địa chỉ *</label>
                            <input type="text" class="form-control" value="<%= SecurityUtils.getPrincipal().getAddress() %>">

                            <label>Email *</label>
                            <input type="email" class="form-control" required value="<%= SecurityUtils.getPrincipal().getEmail() %>">

                            <label>Ghi chú</label>
                            <textarea class="form-control" cols="30" rows="4" placeholder="Ghi chú về đơn hàng"></textarea>
                            </sec:authorize>

                            <sec:authorize access="isAnonymous()">
                                <h2 class="checkout-title">Đặt hàng</h2><!-- End .checkout-title -->
                                <div class="row">
                                    <div class="col-sm-6">
                                        <label>Thông tin người nhận *</label>
                                        <input type="text" class="form-control" placeholder="Họ và tên" required >
                                    </div><!-- End .col-sm-6 -->

                                    <div class="col-sm-6">
                                        <br>
                                        <input type="text" class="form-control" placeholder="Số điện thoại" required >
                                    </div><!-- End .col-sm-6 -->
                                </div><!-- End .row -->

                                <label>Địa chỉ *</label>
                                <input type="text" class="form-control" >

                                <label>Email *</label>
                                <input type="email" class="form-control" required  >

                                <label>Ghi chú</label>
                                <textarea class="form-control" cols="30" rows="4" placeholder="Ghi chú về đơn hàng"></textarea>
                            </sec:authorize>
                        </div><!-- End .col-lg-9 -->
                        <aside class="col-lg-4">
                            <div class="summary">
                                <h3 class="summary-title">Đơn hàng (${Cart.size()})</h3><!-- End .summary-title -->

                                <table class="table table-summary">
                                    <thead>
                                    <tr>
                                        <th>Sản phầm</th>
                                        <th>Thành tiền</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="item" items="${Cart}">
                                        <tr>
                                            <td><a href="#">${item.value.quanty}x ${item.value.book.name}</a></td>
                                            <td>
                                                 <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice}"/> ₫
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr class="summary-subtotal">
                                        <td>Tạm tính:</td>
                                        <td><fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice - 30000}"/> ₫</td>
                                    </tr><!-- End .summary-subtotal -->
                                    <tr>
                                        <td>Phí vận chuyển:</td>
                                        <td><fmt:formatNumber type="number" groupingUsed="true" value="30000"/> ₫</td>
                                    </tr>
                                    <tr class="summary-total">
                                        <td>Tổng:</td>
                                        <td><fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice}"/> ₫</td>
                                    </tr><!-- End .summary-total -->
                                    </tbody>
                                </table><!-- End .table table-summary -->

                                <div class="accordion-summary" id="accordion-payment">
                                    <div class="card">
                                        <div class="card-header" id="heading-1">
                                            <h2 class="card-title">
                                                <a role="button" data-toggle="collapse" href="#collapse-1" aria-expanded="true" aria-controls="collapse-1">
                                                   <i class="fa fa-money"> Thanh toán tiền mặt khi nhận hàng</i>
                                                </a>
                                            </h2>
                                        </div><!-- End .card-header -->
                                    </div><!-- End .card -->
                                </div><!-- End .accordion -->

                                <button type="submit" class="btn btn-outline-primary-2 btn-order btn-block">
                                    <span class="btn-text">Hoàn tất đặt hàng</span>
                                    <span class="btn-hover-text">Hoàn tất đặt hàng</span>
                                </button>
                            </div><!-- End .summary -->
                        </aside><!-- End .col-lg-3 -->
                    </div><!-- End .row -->
                </form>
            </div><!-- End .container -->
        </div><!-- End .checkout -->
    </div><!-- End .page-content -->
</main><!-- End .main -->