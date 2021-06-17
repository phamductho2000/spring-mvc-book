<%--
  Created by IntelliJ IDEA.
  User: tho20
  Date: 6/17/2021
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="main">
    <div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        <div class="container">
            <h1 class="page-title">Checkout<span>Shop</span></h1>
        </div><!-- End .container -->
    </div><!-- End .page-header -->
    <nav aria-label="breadcrumb" class="breadcrumb-nav">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Checkout</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content">
        <div class="checkout">
            <div class="container">
                <div class="checkout-discount">
                    <form action="#">
                        <input type="text" class="form-control" required id="checkout-discount-input">
                        <label for="checkout-discount-input" class="text-truncate">Have a coupon? <span>Click here to enter your code</span></label>
                    </form>
                </div><!-- End .checkout-discount -->
                <form action="#">
                    <div class="row">
                        <div class="col-lg-9">
                            <h2 class="checkout-title">Đặt hàng</h2><!-- End .checkout-title -->
                            <div class="row">
                                <div class="col-sm-6">
                                    <label>Thông tin người nhận *</label>
                                    <input type="text" class="form-control" placeholder="Họ và tên" required>
                                </div><!-- End .col-sm-6 -->

                                <div class="col-sm-6">
                                    <br>
                                    <input type="text" class="form-control" placeholder="Số điện thoại" required>
                                </div><!-- End .col-sm-6 -->
                            </div><!-- End .row -->

                            <label>Địa chỉ *</label>
                            <input type="text" class="form-control">

                            <label>Email *</label>
                            <input type="email" class="form-control" required>

                            <label>Ghi chú</label>
                            <textarea class="form-control" cols="30" rows="4" placeholder="Ghi chú về đơn hàng"></textarea>
                        </div><!-- End .col-lg-9 -->
                        <aside class="col-lg-3">
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
                                            <td>${item.value.totalPrice}₫</td>
                                        </tr>
                                    </c:forEach>
                                    <tr class="summary-subtotal">
                                        <td>Subtotal:</td>
                                        <td>$160.00</td>
                                    </tr><!-- End .summary-subtotal -->
                                    <tr>
                                        <td>Shipping:</td>
                                        <td>Free shipping</td>
                                    </tr>
                                    <tr class="summary-total">
                                        <td>Tổng:</td>
                                        <td>${totalPrice}₫</td>
                                    </tr><!-- End .summary-total -->
                                    </tbody>
                                </table><!-- End .table table-summary -->

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