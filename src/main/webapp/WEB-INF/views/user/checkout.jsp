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
                            <div class="checkout-option">
                                <div class="shipp">
                                    <h3 class="title">1. Chọn hình thức giao hàng</h3>
                                    <div class="main-shipp">
                                        <div class="option-shipp">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                                <label class="form-check-label" for="inlineRadio1">
                                                    <img src="https://salt.tikicdn.com/ts/upload/2a/47/46/0e038f5927f3af308b4500e5b243bcf6.png" width="56" alt="TikiFast" style="display: inline-block; margin-bottom: 8px;">
                                                    <span>Giao tiết kiệm</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="payment">
                                    <h3 class="title">2. Chọn hình thức thanh toán</h3>
                                    <div class="main-payment">
                                        <ul class="list">
                                            <li style="margin-bottom: 20px;">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="optionPayments" id="paymentCash" value="COD">
                                                    <label class="form-check-label" for="paymentCash">
                                                        <img class="method-icon" width="32" src="https://frontend.tikicdn.com/_desktop-next/static/img/icons/checkout/icon-payment-method-cod.svg" alt="cod" style="display: inline-block; margin-left: 5px">
                                                        <span>Thanh toán tiền mặt khi nhận hàng</span>
                                                    </label>
                                                </div>
                                            </li>
                                            <li style="margin-bottom: 20px;">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="optionPayments" id="paymentMomo" value="MOMO">
                                                    <label class="form-check-label" for="paymentMomo">
                                                        <img class="method-icon" width="32" src="https://frontend.tikicdn.com/_desktop-next/static/img/icons/checkout/icon-payment-method-mo-mo.svg" alt="cod" style="display: inline-block; margin-left: 5px">
                                                        <span>Thanh toán bằng ví MoMo</span>
                                                    </label>
                                                </div>
                                            </li>
                                            <li style="margin-bottom: 20px;">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="optionPayments" id="paymentZaloPay" value="ZALOPAY">
                                                    <label class="form-check-label" for="paymentZaloPay">
                                                        <img class="method-icon" width="32" src="https://frontend.tikicdn.com/_desktop-next/static/img/icons/checkout/icon-payment-method-zalo-pay.svg" alt="cod" style="display: inline-block; margin-left: 5px">
                                                        <span>Thanh toán bằng ví ZaloPay</span>
                                                    </label>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div><!-- End .col-lg-8 -->
                        <aside class="col-lg-4">
                            <div class="summary summary-cart">
                                <div>
                                    <span style="color: black">Giao tới</span>
                                    <a href="/tai-khoan/thong-tin" style="float: right">Thay đổi</a>
                                </div>
                                <div>
                                    <input type="hidden" name="userId" value="<%= SecurityUtils.getPrincipal().getId() %>">
                                    <span class="nameUser" style="color: black"><%= SecurityUtils.getPrincipal().getFullName() %></span>
                                    <span style="color: black"><%= SecurityUtils.getPrincipal().getPhone() %></span>
                                </div>
                                <div>
                                    <p><%= SecurityUtils.getPrincipal().getAddress() %></p>
                                </div>
                            </div>

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
                                            <td style="border: none"><a href="#">${item.value.quanty}x ${item.value.book.name}</a></td>
                                            <td style="border: none">
                                                 <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice}"/> ₫
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr class="summary-subtotal">
                                        <td style="border-top: .1rem solid #ebebeb; border-bottom: none">Tạm tính:</td>
                                        <td style="border-top: .1rem solid #ebebeb; border-bottom: none">
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice - 30000}"/> ₫
                                        </td>
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

                                <button type="submit" id="btnPayment" class="btn btn-outline-primary-2 btn-order btn-block">
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